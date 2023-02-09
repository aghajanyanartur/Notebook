package notebook;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	
	int numberOfWords;
	int numberOfSymbols;
	int numberOfCharacters;
	int numberOfParagraphs;
	
	JLabel words;
	JLabel symbols;
	JLabel withoutSpaces;
	JLabel paragraphs;
	
	StatusBar(){
		
		words = new JLabel();
		words.setSize(200, 50);
		words.setText("          " + numberOfWords + "  WORDS     |");
		words.setFont(new Font("ARIAL", Font.PLAIN, 10));
		words.setForeground(Color.BLACK);
		
		symbols = new JLabel();
		symbols.setSize(200, 50);
		symbols.setText("          " + numberOfWords + "  SYMBOLS     |");
		symbols.setFont(new Font("ARIAL", Font.PLAIN, 10));
		symbols.setForeground(Color.BLACK);
		
		withoutSpaces = new JLabel();
		withoutSpaces.setSize(200, 50);
		withoutSpaces.setText("          " + numberOfWords + "  WITHOUT WHITE SPACES     |");
		withoutSpaces.setFont(new Font("ARIAL", Font.PLAIN, 10));
		withoutSpaces.setForeground(Color.BLACK);
		
		paragraphs = new JLabel();
		paragraphs.setSize(200, 50);
		paragraphs.setText("          " + numberOfWords + "  PARAGRAPHS  ");
		paragraphs.setFont(new Font("ARIAL", Font.PLAIN, 10));
		paragraphs.setForeground(Color.BLACK);
		
		this.setBackground(new Color(200, 200, 200));
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		this.add(words);
		this.add(symbols);
		this.add(withoutSpaces);
		this.add(paragraphs);
	}
}
