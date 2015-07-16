package org.de.koalalabs.mute;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class MuteCanvas extends Canvas {

	private static final long serialVersionUID = 1L;

	private boolean init = true;

	private MuteZoomAndDragListener muteZoomAndDragListener;

	private Component muteGuiPanel;

	public MuteCanvas(Component c) {
		setMuteGuiPanel(c);
		this.muteZoomAndDragListener = new MuteZoomAndDragListener(this);
		this.addMouseListener(muteZoomAndDragListener);
		this.addMouseMotionListener(muteZoomAndDragListener);
		this.addMouseWheelListener(muteZoomAndDragListener);
	}

	public MuteCanvas(int minZoomLevel, int maxZoomLevel,
			double zoomMultiplicationFactor) {
		this.muteZoomAndDragListener = new MuteZoomAndDragListener(this,
				minZoomLevel, maxZoomLevel, zoomMultiplicationFactor);
		this.addMouseListener(muteZoomAndDragListener);
		this.addMouseMotionListener(muteZoomAndDragListener);
		this.addMouseWheelListener(muteZoomAndDragListener);
	}

	public void update(Graphics g) {
		Graphics offgc;
		Image offscreen = null;
		Dimension d = getSize();

		// create the offscreen buffer and associated Graphics
		offscreen = createImage(d.width, d.height);
		offgc = offscreen.getGraphics();
		// clear the exposed area
		offgc.setColor(getBackground());
		offgc.fillRect(0, 0, d.width, d.height);
		offgc.setColor(getForeground());
		// do normal redraw
		paint(offgc);
		// transfer offscreen to window
		g.drawImage(offscreen, 0, 0, this);
	}

	public Dimension getPreferredSize() {
		return new Dimension(muteGuiPanel.getWidth(), muteGuiPanel.getHeight());
	}

	public void paint(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		if (init) {
			// Initialize the viewport by moving the origin to the center of the
			// window,
			// and inverting the y-axis to point upwards.
			init = false;
			Dimension d = getSize();
			int xc = d.width / 2;
			int yc = d.height / 2;
			g.translate(xc, yc);
			g.scale(1, -1);
			// Save the viewport to be updated by the ZoomAndPanListener
			muteZoomAndDragListener.setCoordTransform(g.getTransform());
		} else {
			// Restore the viewport after it was updated by the
			// ZoomAndPanListener
			g.setTransform(muteZoomAndDragListener.getCoordTransform());
		}

		// Draw the axes
		g.drawLine(-1000, 0, 1000, 0);
		g.drawLine(0, -1000, 0, 1000);
		// Create an "upside-down" font to correct for the inverted y-axis
		Font font = g.getFont();
		AffineTransform affineTransform = new AffineTransform();
		affineTransform.scale(1, -1);
		g.setFont(font.deriveFont(affineTransform));
	}

	public Component getMuteGuiPanel() {
		return muteGuiPanel;
	}

	public void setMuteGuiPanel(Component muteGuiPanel) {
		this.muteGuiPanel = muteGuiPanel;
	}

}