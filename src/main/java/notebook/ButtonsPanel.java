package notebook;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {
	
	JButton openButton;
	JButton saveButton;
	JButton infoButton;
	JButton zoomInButton;
	JButton zoomOutButton;
	
	ImageIcon openIcon = new ImageIcon("src/main/resources/img/openicon.png");
	ImageIcon saveIcon = new ImageIcon("src/main/resources/img/saveicon.png");
	ImageIcon infoIcon = new ImageIcon("src/main/resources/img/infoicon.png");
	ImageIcon zoomInIcon = new ImageIcon("src/main/resources/img/zoominicon.png");
	ImageIcon zoomOutIcon = new ImageIcon("src/main/resources/img/zoomouticon.png");
	
	ButtonsPanel(){
		
		openButton = new JButton();
		saveButton = new JButton();
		infoButton = new JButton();
		zoomInButton = new JButton();
		zoomOutButton = new JButton();
		
		openButton.setOpaque(false);
		openButton.setContentAreaFilled(false);
		openButton.setBorderPainted(false);
		openButton.setPreferredSize(new Dimension(25, 25));
		openButton.setIcon(openIcon);
		openButton.setToolTipText("Open new file");
		
		saveButton.setOpaque(false);
		saveButton.setContentAreaFilled(false);
		saveButton.setBorderPainted(false);
		saveButton.setPreferredSize(new Dimension(25, 25));
		saveButton.setIcon(saveIcon);
		saveButton.setToolTipText("Save file");
		
		infoButton.setOpaque(false);
		infoButton.setContentAreaFilled(false);
		infoButton.setBorderPainted(false);
		infoButton.setPreferredSize(new Dimension(25, 25));
		infoButton.setIcon(infoIcon);
		infoButton.setToolTipText("Information");
		
		zoomInButton.setOpaque(false);
		zoomInButton.setContentAreaFilled(false);
		zoomInButton.setBorderPainted(false);
		zoomInButton.setPreferredSize(new Dimension(25, 25));
		zoomInButton.setIcon(zoomInIcon);
		zoomInButton.setToolTipText("Zoom in");
		
		zoomOutButton.setOpaque(false);
		zoomOutButton.setContentAreaFilled(false);
		zoomOutButton.setBorderPainted(false);
		zoomOutButton.setPreferredSize(new Dimension(25, 25));
		zoomOutButton.setIcon(zoomOutIcon);
		zoomOutButton.setToolTipText("Zoom out");
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(new Color(235, 235, 235));
		
		this.add(openButton);
		this.add(saveButton);
		this.add(infoButton);
		this.add(zoomInButton);
		this.add(zoomOutButton);
	}

}
