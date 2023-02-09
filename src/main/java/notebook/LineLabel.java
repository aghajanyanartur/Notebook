package notebook;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class LineLabel extends JTextArea {
	
	String[] lines;
	
	LineLabel(){
		
		this.setBackground(new Color(180, 180, 180));
		this.setForeground(Color.BLACK);
		this.setOpaque(true);
		this.setEditable(false);
		this.setText("1");
		this.setMargin(new Insets(10, 10, 0, 10));
		this.setFont(new Font("Arial", Font.PLAIN, 15));
		this.setVisible(false);
	}
	
	public void setLineNumbers(int num, LineLabel l) {
		l.setText("");
		for(int i = 1; i <= num; i++) {
			l.setText(l.getText() + i + "\n");
		}
	}
}
