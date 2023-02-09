package notebook;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {

	JMenu fileMenu;
	JMenu viewMenu;
	JMenu helpMenu;
	
	JMenu showView;
	JMenu appearance;
	
	JMenuItem showLines;
	JMenuItem showStatusBar;
	
	JMenuItem darkTheme;
	JMenuItem purpleTheme;
	JMenuItem classicTheme;
	JMenuItem lightTheme;
	JMenuItem yellowTheme;
	JMenuItem hackerTheme;
	
	JMenuItem shortcuts;
	JMenuItem infoMenu;
	
	JMenuItem openMenu;
	JMenuItem saveMenu;
	JMenuItem exitMenu;
	
	boolean linesVisible = false;
	boolean statusBarVisible = true;
	
	Menu(){
		
		fileMenu = new JMenu("File");
		viewMenu = new JMenu("View");
		helpMenu = new JMenu("Help");
		
		showView = new JMenu("Show View");
		appearance  = new JMenu("Appearance");
		
		showLines = new JMenuItem("       Show Lines");
		showStatusBar  = new JMenuItem(" ●   Show Status Bar");
		
		darkTheme = new JMenuItem("       Dark Theme");
		purpleTheme = new JMenuItem("       Purple Theme");
		classicTheme = new JMenuItem("       Classic Theme");
		lightTheme = new JMenuItem("       Light Theme");
		yellowTheme = new JMenuItem("       Yellow Theme");
		hackerTheme = new JMenuItem("       Hacker Theme");
		
		shortcuts = new JMenuItem("       Shortcuts");
		infoMenu = new JMenuItem("       About program");
		
		openMenu = new JMenuItem("       Open");
		saveMenu = new JMenuItem("       Save");
		exitMenu = new JMenuItem("       Exit");
		
		fileMenu.setForeground(Color.BLACK);
		viewMenu.setForeground(Color.BLACK);
		helpMenu.setForeground(Color.BLACK);
		
		showView.add(showLines);
		showView.add(showStatusBar);
		
		appearance.add(darkTheme);
		appearance.add(purpleTheme);
		appearance.add(classicTheme);
		appearance.add(lightTheme);
		appearance.add(yellowTheme);
		appearance.add(hackerTheme);
		
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.add(exitMenu);
		
		viewMenu.add(showView);
		viewMenu.add(appearance);
		
		helpMenu.add(shortcuts);
		helpMenu.add(infoMenu);
		
		this.setSize(new Dimension(400, 50));
		this.setBackground(new Color(245, 245, 245));
		
		this.add(fileMenu);
		this.add(viewMenu);
		this.add(helpMenu);
	}
}
