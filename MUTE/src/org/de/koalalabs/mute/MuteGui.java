package org.de.koalalabs.mute;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MuteGui extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenuBar menuLeiste;
	private JMenu mnDatei;
	private JMenuItem mntmSpeichern;
	private JSplitPane splitPane;
	private JPanel toolPanel;
	private JPanel diagrammPanel;
	private JButton textBtn;
	private JButton actionBtn;
	private JButton pfeilBtn;
	private Canvas diagrammCanvas;
	private JLabel lblSzene;
	private JLabel lblAktion;
	private JLabel lblVerbindung;
	public MuteGui() {
		initGUI();
	}
	private void initGUI() {
		setTitle("MUTE");
		setPreferredSize(new Dimension(900, 900));
		setMinimumSize(new Dimension(500, 500));
		setSize(new Dimension(900, 900));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		setJMenuBar(getMenuLeiste());
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		getContentPane().add(getSplitPane(), gbc_splitPane);
		setVisible(true);
	}

	private JMenuBar getMenuLeiste() {
		if (menuLeiste == null) {
			menuLeiste = new JMenuBar();
			menuLeiste.add(getMnDatei());
		}
		return menuLeiste;
	}
	private JMenu getMnDatei() {
		if (mnDatei == null) {
			mnDatei = new JMenu("Datei");
			mnDatei.add(getMntmSpeichern());
		}
		return mnDatei;
	}
	private JMenuItem getMntmSpeichern() {
		if (mntmSpeichern == null) {
			mntmSpeichern = new JMenuItem("Speichern");
		}
		return mntmSpeichern;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getToolPanel());
			splitPane.setRightComponent(getDiagrammPanel());
			splitPane.setDividerLocation(150);
		}
		return splitPane;
	}
	private JPanel getToolPanel() {
		if (toolPanel == null) {
			toolPanel = new JPanel();
			toolPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
			GridBagLayout gbl_toolPanel = new GridBagLayout();
			gbl_toolPanel.columnWidths = new int[]{133, 0};
			gbl_toolPanel.rowHeights = new int[]{32, 68, 29, 0, 30, 0, 0};
			gbl_toolPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_toolPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			toolPanel.setLayout(gbl_toolPanel);
			GridBagConstraints gbc_lblSzene = new GridBagConstraints();
			gbc_lblSzene.insets = new Insets(0, 0, 5, 0);
			gbc_lblSzene.gridx = 0;
			gbc_lblSzene.gridy = 0;
			toolPanel.add(getLblSzene(), gbc_lblSzene);
			GridBagConstraints gbc_textBtn = new GridBagConstraints();
			gbc_textBtn.fill = GridBagConstraints.BOTH;
			gbc_textBtn.insets = new Insets(0, 0, 5, 0);
			gbc_textBtn.gridx = 0;
			gbc_textBtn.gridy = 1;
			toolPanel.add(getTextBtn(), gbc_textBtn);
			GridBagConstraints gbc_lblAktion = new GridBagConstraints();
			gbc_lblAktion.insets = new Insets(0, 0, 5, 0);
			gbc_lblAktion.gridx = 0;
			gbc_lblAktion.gridy = 2;
			toolPanel.add(getLblAktion(), gbc_lblAktion);
			GridBagConstraints gbc_actionBtn = new GridBagConstraints();
			gbc_actionBtn.fill = GridBagConstraints.HORIZONTAL;
			gbc_actionBtn.insets = new Insets(0, 0, 5, 0);
			gbc_actionBtn.gridx = 0;
			gbc_actionBtn.gridy = 3;
			toolPanel.add(getActionBtn(), gbc_actionBtn);
			GridBagConstraints gbc_lblVerbindung = new GridBagConstraints();
			gbc_lblVerbindung.insets = new Insets(0, 0, 5, 0);
			gbc_lblVerbindung.gridx = 0;
			gbc_lblVerbindung.gridy = 4;
			toolPanel.add(getLblVerbindung(), gbc_lblVerbindung);
			GridBagConstraints gbc_pfeilBtn = new GridBagConstraints();
			gbc_pfeilBtn.fill = GridBagConstraints.HORIZONTAL;
			gbc_pfeilBtn.gridx = 0;
			gbc_pfeilBtn.gridy = 5;
			toolPanel.add(getPfeilBtn(), gbc_pfeilBtn);
		}
		return toolPanel;
	}
	private JPanel getDiagrammPanel() {
		if (diagrammPanel == null) {
			diagrammPanel = new JPanel();
			GridBagLayout gbl_diagrammPanel = new GridBagLayout();
			gbl_diagrammPanel.columnWidths = new int[]{0, 0};
			gbl_diagrammPanel.rowHeights = new int[]{0, 0};
			gbl_diagrammPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_diagrammPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			diagrammPanel.setLayout(gbl_diagrammPanel);
			GridBagConstraints gbc_diagrammCanvas = new GridBagConstraints();
			gbc_diagrammCanvas.gridx = 0;
			gbc_diagrammCanvas.gridy = 0;
			diagrammPanel.add(getDiagrammCanvas(), gbc_diagrammCanvas);
		}
		return diagrammPanel;
	}
	private JButton getTextBtn() {
		if (textBtn == null) {
			textBtn = new JButton("Szene");
		}
		return textBtn;
	}
	private JButton getActionBtn() {
		if (actionBtn == null) {
			actionBtn = new JButton("Aktion");
			actionBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
		}
		return actionBtn;
	}
	private JButton getPfeilBtn() {
		if (pfeilBtn == null) {
			pfeilBtn = new JButton("");
			pfeilBtn.setContentAreaFilled(false);
			pfeilBtn.setIcon(new ImageIcon(MuteGui.class.getResource("/icons/Pfeil.png")));
			pfeilBtn.setBorderPainted(false);
		}
		return pfeilBtn;
	}
	private Canvas getDiagrammCanvas() {
		if (diagrammCanvas == null) {
			diagrammCanvas = new Canvas();
		}
		return diagrammCanvas;
	}
	private JLabel getLblSzene() {
		if (lblSzene == null) {
			lblSzene = new JLabel("Szene hinzuf\u00FCgen");
		}
		return lblSzene;
	}
	private JLabel getLblAktion() {
		if (lblAktion == null) {
			lblAktion = new JLabel("Aktion hinzuf\u00FCgen");
		}
		return lblAktion;
	}
	private JLabel getLblVerbindung() {
		if (lblVerbindung == null) {
			lblVerbindung = new JLabel("Verbindung hinzuf\u00FCgen");
		}
		return lblVerbindung;
	}
}
