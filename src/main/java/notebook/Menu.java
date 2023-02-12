package notebook;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public final class Menu extends JMenuBar {

	private JMenu fileMenu;
	private JMenu viewMenu;
	private JMenu helpMenu;

	private JMenu showView;
	private JMenu appearance;

	private JMenuItem showLines;
	private JMenuItem showStatusBar;

	private JMenuItem darkTheme;
	private JMenuItem purpleTheme;
	private JMenuItem classicTheme;
	private JMenuItem lightTheme;
	private JMenuItem yellowTheme;
	private JMenuItem hackerTheme;

	private JMenuItem shortcuts;
	private JMenuItem infoMenu;

	private JMenuItem openMenu;
	private JMenuItem saveMenu;
	private JMenuItem exitMenu;
	
	public Menu(){
		
		initializeComponents();
		addThemesToAppearance(darkTheme, purpleTheme, classicTheme, lightTheme, yellowTheme, hackerTheme);
		addToFileMenu(openMenu, saveMenu, exitMenu);
		addToHelpMenu(shortcuts, infoMenu);
		addToShowView(showLines, showStatusBar);
		addToViewMenu(showView, appearance);
		setBackgrounds();
		setMenuBarParameters();
	}
	private void initializeComponents(){
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
	}

	private void addThemesToAppearance(JMenuItem... themes) {
		for (JMenuItem theme : themes) {
			appearance.add(theme);
		}
	}

	private void addToFileMenu(JMenuItem... menuItems) {
		for (JMenuItem menuItem : menuItems) {
			fileMenu.add(menuItem);
		}
	}

	private void addToHelpMenu(JMenuItem... menuItems) {
		for (JMenuItem menuItem : menuItems) {
			helpMenu.add(menuItem);
		}
	}

	private void addToShowView(JMenuItem... menuItems) {
		for (JMenuItem menuItem : menuItems) {
			showView.add(menuItem);
		}
	}

	private void addToViewMenu(JMenuItem... menuItems) {
		for (JMenuItem menuItem : menuItems) {
			viewMenu.add(menuItem);
		}
	}

	private void setBackgrounds(){
		fileMenu.setForeground(Color.BLACK);
		viewMenu.setForeground(Color.BLACK);
		helpMenu.setForeground(Color.BLACK);
	}

	private void setMenuBarParameters(){
		this.setSize(new Dimension(400, 50));
		this.setBackground(new Color(245, 245, 245));
		this.add(fileMenu);
		this.add(viewMenu);
		this.add(helpMenu);
	}

	public JMenu getFileMenu() {
		return fileMenu;
	}

	public JMenu getViewMenu() {
		return viewMenu;
	}

	@Override
	public JMenu getHelpMenu() {
		return helpMenu;
	}

	public JMenu getShowView() {
		return showView;
	}

	public JMenu getAppearance() {
		return appearance;
	}

	public JMenuItem getShowLines() {
		return showLines;
	}

	public JMenuItem getShowStatusBar() {
		return showStatusBar;
	}

	public JMenuItem getDarkTheme() {
		return darkTheme;
	}

	public JMenuItem getPurpleTheme() {
		return purpleTheme;
	}

	public JMenuItem getClassicTheme() {
		return classicTheme;
	}

	public JMenuItem getLightTheme() {
		return lightTheme;
	}

	public JMenuItem getYellowTheme() {
		return yellowTheme;
	}

	public JMenuItem getHackerTheme() {
		return hackerTheme;
	}

	public JMenuItem getShortcuts() {
		return shortcuts;
	}

	public JMenuItem getInfoMenu() {
		return infoMenu;
	}

	public JMenuItem getOpenMenu() {
		return openMenu;
	}

	public JMenuItem getSaveMenu() {
		return saveMenu;
	}

	public JMenuItem getExitMenu() {
		return exitMenu;
	}
}
