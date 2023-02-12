package notebook;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public final class ThemeSetter {

	private JFrame frame;
	private JTextArea textArea;
	private JTextArea lines;
	private JPanel statusBar;
	private JLabel words;
	private JLabel symbols;
	private JLabel withoutSpaces;
	private JLabel paragraphs;
	private Menu menu;
	private JMenu fileMenu;
	private JMenu viewMenu;
	private JMenu helpMenu;
	private JPanel buttonsPanel;
	private int fontSize;

	public ThemeSetter(JFrame frame, JTextArea textArea, JTextArea lines, JPanel statusBar,
					   JLabel words, JLabel symbols, JLabel withoutSpaces, JLabel paragraphs,
					   Menu menu, JMenu fileMenu, JMenu viewMenu, JMenu helpMenu, JPanel buttonsPanel, int fontSize) {
		this.frame = frame;
		this.textArea = textArea;
		this.lines = lines;
		this.statusBar = statusBar;
		this.words = words;
		this.symbols = symbols;
		this.withoutSpaces = withoutSpaces;
		this.paragraphs = paragraphs;
		this.menu = menu;
		this.fileMenu = fileMenu;
		this.viewMenu = viewMenu;
		this.helpMenu = helpMenu;
		this.buttonsPanel = buttonsPanel;
		this.fontSize = fontSize;
	}

	public void setTheme(Themes theme) {
		switch (theme){
			case CLASSIC:
				configureClassicTheme();
				break;
			case DARK:
				configureDarkTheme();
				break;
			case LIGHT:
				configureLightTheme();
				break;
			case HACKER:
				configureHackerTheme();
				break;
			case PURPLE:
				configurePurpleTheme();
				break;
			case YELLOW:
				configureYellowTheme();
				break;
		}
	}

	private void configureClassicTheme(){
		textArea.setBackground(new Color(211, 211, 211));
		textArea.setCaretColor(Color.BLUE);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Arial", Font.PLAIN, fontSize));
		lines.setBackground(new Color(180, 180, 180));
		lines.setForeground(Color.BLACK);
		lines.setFont(new Font("Arial", Font.PLAIN, fontSize));
		statusBar.setBackground(new Color(200, 200, 200));
		words.setForeground(Color.BLACK);
		symbols.setForeground(Color.BLACK);
		withoutSpaces.setForeground(Color.BLACK);
		paragraphs.setForeground(Color.BLACK);
		menu.setBackground(new Color(245, 245, 245));
		fileMenu.setForeground(Color.BLACK);
		viewMenu.setForeground(Color.BLACK);
		helpMenu.setForeground(Color.BLACK);
		buttonsPanel.setBackground(new Color(235, 235, 235));
	}
	private void configureDarkTheme(){
		textArea.setBackground(new Color(0x1E2328));
		textArea.setForeground(Color.WHITE);
		textArea.setCaretColor(Color.WHITE);
		textArea.setFont(new Font("Arial", Font.PLAIN, fontSize));
		lines.setBackground(new Color(35, 35, 35));
		lines.setForeground(Color.WHITE);
		lines.setFont(new Font("Arial", Font.PLAIN, fontSize));
		statusBar.setBackground(new Color(35, 35, 35));
		words.setForeground(Color.WHITE);
		symbols.setForeground(Color.WHITE);
		withoutSpaces.setForeground(Color.WHITE);
		paragraphs.setForeground(Color.WHITE);
		menu.setBackground(new Color(50, 50, 50));
		fileMenu.setForeground(Color.WHITE);
		viewMenu.setForeground(Color.WHITE);
		helpMenu.setForeground(Color.WHITE);
		buttonsPanel.setBackground(new Color(50, 50, 50));
	}
	private void configureHackerTheme(){
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.GREEN);
		textArea.setCaretColor(Color.GREEN);
		textArea.setFont(new Font("Courier New", Font.PLAIN, fontSize));
		lines.setBackground(Color.DARK_GRAY);
		lines.setForeground(Color.ORANGE);
		lines.setFont(new Font("Courier New", Font.PLAIN, fontSize));
		statusBar.setBackground(Color.DARK_GRAY);
		words.setForeground(Color.ORANGE);
		symbols.setForeground(Color.ORANGE);
		withoutSpaces.setForeground(Color.ORANGE);
		paragraphs.setForeground(Color.ORANGE);
		menu.setBackground(Color.DARK_GRAY);
		fileMenu.setForeground(Color.ORANGE);
		viewMenu.setForeground(Color.ORANGE);
		helpMenu.setForeground(Color.ORANGE);
		buttonsPanel.setBackground(Color.DARK_GRAY);
	}
	private void configureYellowTheme(){
		textArea.setBackground(new Color(0xFFFF9F));
		textArea.setForeground(Color.BLACK);
		textArea.setCaretColor(Color.BLACK);
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
		lines.setBackground(new Color(0xFFF600));
		lines.setForeground(Color.BLACK);
		lines.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
		statusBar.setBackground(new Color(0xFFF600));
		words.setForeground(Color.BLACK);
		symbols.setForeground(Color.BLACK);
		withoutSpaces.setForeground(Color.BLACK);
		paragraphs.setForeground(Color.BLACK);
		menu.setBackground(new Color(0xFFF600));
		fileMenu.setForeground(Color.BLACK);
		viewMenu.setForeground(Color.BLACK);
		helpMenu.setForeground(Color.BLACK);
		buttonsPanel.setBackground(new Color(0xFFF600));
	}
	private void configurePurpleTheme(){
		textArea.setBackground(new Color(0xE090DF));
		textArea.setForeground(new Color(0x00094B));
		textArea.setCaretColor(new Color(0x00094B));
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
		lines.setBackground(new Color(0xA44CD3));
		lines.setForeground(new Color(0x00094B));
		lines.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
		statusBar.setBackground(new Color(0x8800C7));
		words.setForeground(Color.BLACK);
		symbols.setForeground(Color.BLACK);
		withoutSpaces.setForeground(Color.BLACK);
		paragraphs.setForeground(Color.BLACK);
		menu.setBackground(new Color(0x8800C7));
		fileMenu.setForeground(Color.BLACK);
		viewMenu.setForeground(Color.BLACK);
		helpMenu.setForeground(Color.BLACK);
		buttonsPanel.setBackground(new Color(0x8800C7));
	}
	private void configureLightTheme(){
		textArea.setBackground(Color.WHITE);
		textArea.setForeground(new Color (75, 75, 75));
		textArea.setCaretColor(new Color (75, 75, 75));
		textArea.setFont(new Font("Arial", Font.PLAIN, fontSize));
		lines.setBackground(Color.WHITE);
		lines.setForeground(new Color (75, 75, 75));
		lines.setFont(new Font("Arial", Font.PLAIN, fontSize));
		statusBar.setBackground(Color.WHITE);
		words.setForeground(new Color (75, 75, 75));
		symbols.setForeground(new Color (75, 75, 75));
		withoutSpaces.setForeground(new Color (75, 75, 75));
		paragraphs.setForeground(new Color (75, 75, 75));
		menu.setBackground(Color.WHITE);
		fileMenu.setForeground(new Color (75, 75, 75));
		viewMenu.setForeground(new Color (75, 75, 75));
		helpMenu.setForeground(new Color (75, 75, 75));
		buttonsPanel.setBackground(Color.WHITE);
	}
}