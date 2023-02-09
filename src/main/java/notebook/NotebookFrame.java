package notebook;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NotebookFrame extends JFrame implements ActionListener, CaretListener, KeyListener {
	
	int fontSize;
	boolean isSaved = false;
	boolean ctrlPressed = false;
	
	ImageIcon appIcon;
	JTextArea textArea;
	JScrollPane scroll;
	File fileToOpen;
	File fileToSave;
	BufferedWriter writer;
	BufferedReader reader;
	ButtonsPanel buttonsPanel;
	JFileChooser fileChooser;
	Menu menu;
	StatusBar statusBar;
	LineLabel lines;
	JPanel textAndLines;
	Scanner scan;
	ThemeSetter themeSetter;
	
	String informationAboutProgram;
	String shortcutsText;
	String fileName = "";
	String allContent = "";
	String[] numOfLines;
	
	NotebookFrame(){
		
		informationAboutProgram = "This is a very simple notebook, made with Java";
		shortcutsText = "  CTRL  O         Open\n"
				+ "  CTRL  S         Save\n  CTRL  +         Zoom In\n  CTRL   -         Zoom Out";
		fontSize = 15;
		
		// initializing components
		appIcon = new ImageIcon("src/main/resources/img/icon.png");
		textArea = new JTextArea();
		buttonsPanel = new ButtonsPanel();
		menu = new Menu();
		statusBar = new StatusBar();
		lines = new LineLabel();
		textAndLines = new JPanel();
		themeSetter = new ThemeSetter(this, textArea, lines, statusBar,
				statusBar.words, statusBar.symbols, statusBar.withoutSpaces, statusBar.paragraphs,
				menu, menu.fileMenu, menu.viewMenu, menu.helpMenu, buttonsPanel, fontSize);
		
		// setting TextArea
		textArea.setFont(new Font("Arial", Font.PLAIN, fontSize));
		textArea.setBackground(new Color(211, 211, 211));
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setLineWrap(true);
		textArea.setCaretColor(Color.BLUE);
		textArea.setForeground(Color.BLACK);
		textAndLines.setLayout(new BorderLayout());
		textAndLines.add(lines, BorderLayout.WEST);
		textAndLines.add(textArea);
		scroll = new JScrollPane(textAndLines, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		// adding interfaces to all components that need it
		buttonsPanel.openButton.addActionListener(this);
		buttonsPanel.saveButton.addActionListener(this);
		buttonsPanel.infoButton.addActionListener(this);
		buttonsPanel.zoomInButton.addActionListener(this);
		buttonsPanel.zoomOutButton.addActionListener(this);
		menu.showLines.addActionListener(this);
		menu.showStatusBar.addActionListener(this);
		menu.darkTheme.addActionListener(this);
		menu.classicTheme.addActionListener(this);
		menu.purpleTheme.addActionListener(this);
		menu.lightTheme.addActionListener(this);
		menu.yellowTheme.addActionListener(this);
		menu.hackerTheme.addActionListener(this);
		menu.shortcuts.addActionListener(this);
		menu.infoMenu.addActionListener(this);
		menu.openMenu.addActionListener(this);
		menu.saveMenu.addActionListener(this);
		menu.exitMenu.addActionListener(this);
		textArea.addCaretListener(this);
		textArea.addKeyListener(this);
		
		// setting Frame
		this.setTitle("Notebook");
		this.setBounds(200, 100, 1000, 600);
		this.setBackground(new Color(211, 211, 211));
		this.setResizable(true);
		this.setIconImage(appIcon.getImage());
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.add(scroll);
		this.add(buttonsPanel, BorderLayout.NORTH);
		this.add(statusBar, BorderLayout.SOUTH);
		this.setJMenuBar(menu);
		
		themeSetter.setTheme(Themes.CLASSIC);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// buttons and menus
		if(e.getSource()==buttonsPanel.saveButton || e.getSource()==menu.saveMenu) { saveFile(); }
		if(e.getSource()==buttonsPanel.openButton || e.getSource()==menu.openMenu) { openFile(); }
		if(e.getSource()==buttonsPanel.infoButton || e.getSource()==menu.infoMenu) {
			 JOptionPane.showMessageDialog(null, informationAboutProgram, "Notebook by Artur", JOptionPane.NO_OPTION);
		}
		if(e.getSource()==menu.exitMenu) { System.exit(0); }
		
		// zoom in - out
		if(e.getSource()==buttonsPanel.zoomInButton) { zoomIn(); }
		if(e.getSource()==buttonsPanel.zoomOutButton) { zoomOut(); }
		
		// show view
		if(e.getSource()==menu.showLines) {
			if(!menu.linesVisible) {
				lines.setVisible(true);
				menu.showLines.setText(" ●   Show Lines");
				menu.linesVisible = true;
			} else {
				lines.setVisible(false);
				menu.showLines.setText("       Show Lines");
				menu.linesVisible = false;
			}
		}
		if(e.getSource()==menu.showStatusBar) {
			if(!menu.statusBarVisible) {
				statusBar.setVisible(true);
				menu.showStatusBar.setText(" ●   Show Status Bar");
				menu.statusBarVisible = true;
			} else {
				statusBar.setVisible(false);
				menu.showStatusBar.setText("       Show Status Bar");
				menu.statusBarVisible = false;
			}
		}
		
		// help menu
		if(e.getSource()==menu.shortcuts) {
			JOptionPane.showMessageDialog(null, shortcutsText, "Shortcuts", JOptionPane.NO_OPTION);
		}
		
		// themes
		if(e.getSource()==menu.darkTheme)	themeSetter.setTheme(Themes.DARK);
		if(e.getSource()==menu.classicTheme)	themeSetter.setTheme(Themes.CLASSIC);
		if(e.getSource()==menu.lightTheme)	themeSetter.setTheme(Themes.LIGHT);
		if(e.getSource()==menu.hackerTheme)	themeSetter.setTheme(Themes.HACKER);
		if(e.getSource()==menu.yellowTheme)	themeSetter.setTheme(Themes.YELLOW);
		if(e.getSource()==menu.purpleTheme)	themeSetter.setTheme(Themes.PURPLE);
	}
	
	public void saveFile() {
		System.out.println(fileName);
		if(fileName != "" && fileName != null) {
			try {
				writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()));
				writer.write(textArea.getText());
				writer.close();
			} catch (IOException ioe) {ioe.printStackTrace();}
			catch (NullPointerException npe) {npe.printStackTrace();}
		} else {
			JFileChooser fileSaver = new JFileChooser(); 
			
			fileSaver.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fileSaver.showSaveDialog(null);
			if(fileSaver.getSelectedFile() != null) {
				fileToSave = new File(fileSaver.getCurrentDirectory() + "\\" + 
						fileSaver.getSelectedFile().getName() + ".txt");
				
				try {
					writer = new BufferedWriter(new FileWriter(fileToSave));
					writer.write(textArea.getText());
					writer.close();
				} catch (IOException ioe) {ioe.printStackTrace();}
				catch (NullPointerException npe) {npe.printStackTrace();}
			}
		}
		isSaved = true;
	}
	
	public void openFile() {
		
		if(!isSaved) {
			
			int answer = JOptionPane.showConfirmDialog(null, "Do you want to save the file?",
					"Save the file", JOptionPane.YES_NO_CANCEL_OPTION);
			if(answer == JOptionPane.YES_OPTION) {
				saveFile();
			} else {
				isSaved = true;
				openFile();
			}
		} else {
			fileChooser = new JFileChooser();
			int choice = fileChooser.showOpenDialog(null);
			if(choice == JFileChooser.APPROVE_OPTION) {
				 try {
					fileToOpen = fileChooser.getSelectedFile();
					reader = new BufferedReader(new FileReader(fileToOpen));
					scan = new Scanner(fileToOpen);
					fileName = fileChooser.getSelectedFile().getName().substring(0, fileChooser.getSelectedFile().getName().length()-4);
					
					while(scan.hasNextLine()) {
						allContent = allContent.concat(scan.nextLine()+"\n");
					}
					textArea.setText(allContent);
					reader.close();
				 } catch (FileNotFoundException e1) {e1.printStackTrace();}
				 	catch (IOException e1) {e1.printStackTrace();}
			}
			isSaved = false;
		}
		
		
	}

	public void zoomIn() {
		if(fontSize < 61) {
			fontSize += 2;
			textArea.setFont(new Font(textArea.getFont().getFontName(), Font.PLAIN, fontSize));
			lines.setFont(new Font(lines.getFont().getFontName(), Font.PLAIN, fontSize));
		}
	}
	public void zoomOut() {
		if(fontSize > 14) {
			fontSize -= 2;
			textArea.setFont(new Font(textArea.getFont().getFontName(), Font.PLAIN, fontSize));
			lines.setFont(new Font(lines.getFont().getFontName(), Font.PLAIN, fontSize));
		}
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		if(e.getSource() == textArea) {
			statusBar.symbols.setText("          " + Counter.charCount(textArea.getText()) + "  SYMBOLS     |");
			statusBar.words.setText("          " + Counter.wordCount(textArea.getText()) + "  WORDS     |");
			statusBar.withoutSpaces.setText("          " + Counter.withoutSpacesCount(textArea.getText()) + "  WITHOUT WHITE SPACES     |");
			statusBar.paragraphs.setText("          " + Counter.paragraphCount(textArea.getText()) + "  PARAGRAPHS  ");
			
			lines.setLineNumbers(textArea.getLineCount(), lines);
			
			isSaved = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 17) {
			ctrlPressed = true;
		}
		
		//		zoom in and out	
		if(ctrlPressed == true && e.getKeyCode() == 107) {
			zoomIn();
		}
		if(ctrlPressed == true && e.getKeyCode() == 109) {
			zoomOut();
		}
		
		//		open and save
		if(ctrlPressed == true && e.getKeyCode() == 79) {
			openFile();
			ctrlPressed = false;
		}
		if(ctrlPressed == true && e.getKeyCode() == 83) {
			saveFile();
			ctrlPressed = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 17) {
			ctrlPressed = false;
		}
	}
}