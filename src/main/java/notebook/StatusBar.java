package notebook;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public final class StatusBar extends JPanel {
	
	private static final Font STATUS_BAR_FONT = new Font("ARIAL", Font.PLAIN, 10);
	private static final int WIDTH = 200;
	private static final int HEIGHT = 50;

	
	private JLabel words;
	private JLabel symbols;
	private JLabel withoutSpaces;
	private JLabel paragraphs;
	
	public StatusBar(){
		initializeComponents();
		configureWordsLabel();
		configureSymbolsLabel();
		configureWithoutSpacesLabel();
		configureParagraphsLabel();
		setStatusBarParameters();
	}

	private void setStatusBarParameters() {
		this.setBackground(new Color(200, 200, 200));
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(words);
		this.add(symbols);
		this.add(withoutSpaces);
		this.add(paragraphs);
	}

	private void configureSymbolsLabel() {
		symbols.setSize(WIDTH, HEIGHT);
		symbols.setText(String.format("%11d%s", 0, "  SYMBOLS   |"));
		symbols.setFont(STATUS_BAR_FONT);
		symbols.setForeground(Color.BLACK);
	}

	private void configureWordsLabel() {
		words.setSize(WIDTH, HEIGHT);
		words.setText(String.format("%11d%s", 0, "  WORDS   |"));
		words.setFont(STATUS_BAR_FONT);
		words.setForeground(Color.BLACK);
	}

	private void configureWithoutSpacesLabel() {
		withoutSpaces.setSize(WIDTH, HEIGHT);
		withoutSpaces.setText(String.format("%11d%s", 0, "  WITHOUT WHITE SPACES   |"));
		withoutSpaces.setFont(STATUS_BAR_FONT);
		withoutSpaces.setForeground(Color.BLACK);
	}

	private void configureParagraphsLabel() {
		paragraphs.setSize(WIDTH, HEIGHT);
		paragraphs.setText(String.format("%11d%s", 0, "  PARAGRAPHS   |"));
		paragraphs.setFont(STATUS_BAR_FONT);
		paragraphs.setForeground(Color.BLACK);
	}

	private void initializeComponents(){
		words = new JLabel();
		symbols = new JLabel();
		withoutSpaces = new JLabel();
		paragraphs = new JLabel();
	}

	public JLabel getWords() {
		return words;
	}

	public JLabel getSymbols() {
		return symbols;
	}

	public JLabel getWithoutSpaces() {
		return withoutSpaces;
	}

	public JLabel getParagraphs() {
		return paragraphs;
	}
}
