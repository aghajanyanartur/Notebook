package notebook;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public final class ButtonsPanel extends JPanel {

	private static final ImageIcon OPEN_ICON = new ImageIcon("src/main/resources/img/openicon.png");
	private static final ImageIcon SAVE_ICON = new ImageIcon("src/main/resources/img/saveicon.png");
	private static final ImageIcon INFO_ICON = new ImageIcon("src/main/resources/img/infoicon.png");
	private static final ImageIcon ZOOM_IN_ICON = new ImageIcon("src/main/resources/img/zoominicon.png");
	private static final ImageIcon ZOOM_OUT_ICON = new ImageIcon("src/main/resources/img/zoomouticon.png");


	private JButton openButton;
	private JButton saveButton;
	private JButton infoButton;
	private JButton zoomInButton;
	private JButton zoomOutButton;

	public ButtonsPanel(){
		initializeComponents();
		configureOpenButton();
		configureSaveButton();
		configureInfoButton();
		configureZoomInButton();
		configureZoomOutButton();
		setPanelParameters();
	}

	private void setPanelParameters() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(new Color(235, 235, 235));

		this.add(openButton);
		this.add(saveButton);
		this.add(infoButton);
		this.add(zoomInButton);
		this.add(zoomOutButton);
	}

	private void configureZoomOutButton() {
		zoomOutButton.setOpaque(false);
		zoomOutButton.setContentAreaFilled(false);
		zoomOutButton.setBorderPainted(false);
		zoomOutButton.setPreferredSize(new Dimension(25, 25));
		zoomOutButton.setIcon(ZOOM_OUT_ICON);
		zoomOutButton.setToolTipText("Zoom out");
	}

	private void configureZoomInButton() {
		zoomInButton.setOpaque(false);
		zoomInButton.setContentAreaFilled(false);
		zoomInButton.setBorderPainted(false);
		zoomInButton.setPreferredSize(new Dimension(25, 25));
		zoomInButton.setIcon(ZOOM_IN_ICON);
		zoomInButton.setToolTipText("Zoom in");
	}

	private void configureInfoButton() {
		infoButton.setOpaque(false);
		infoButton.setContentAreaFilled(false);
		infoButton.setBorderPainted(false);
		infoButton.setPreferredSize(new Dimension(25, 25));
		infoButton.setIcon(INFO_ICON);
		infoButton.setToolTipText("Information");
	}

	private void configureSaveButton() {
		saveButton.setOpaque(false);
		saveButton.setContentAreaFilled(false);
		saveButton.setBorderPainted(false);
		saveButton.setPreferredSize(new Dimension(25, 25));
		saveButton.setIcon(SAVE_ICON);
		saveButton.setToolTipText("Save file");
	}

	private void configureOpenButton() {
		openButton.setOpaque(false);
		openButton.setContentAreaFilled(false);
		openButton.setBorderPainted(false);
		openButton.setPreferredSize(new Dimension(25, 25));
		openButton.setIcon(OPEN_ICON);
		openButton.setToolTipText("Open new file");
	}

	private void initializeComponents(){
		openButton = new JButton();
		saveButton = new JButton();
		infoButton = new JButton();
		zoomInButton = new JButton();
		zoomOutButton = new JButton();
	}

	public JButton getOpenButton() {
		return openButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getInfoButton() {
		return infoButton;
	}

	public JButton getZoomInButton() {
		return zoomInButton;
	}

	public JButton getZoomOutButton() {
		return zoomOutButton;
	}
}
