package notebook;

import java.awt.*;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public final class NotebookFrame extends JFrame implements ActionListener, CaretListener, KeyListener {


	private static final int CTRL_KEY = 17;
	private static final int ZOOM_IN = 107;
	private static final int ZOOM_OUT = 109;
	private static final int OPEN = 79;
	private static final int SAVE = 83;
	private static final String INFORMATION_ABOUT_PROGRAM = "This is a very simple notebook, made with Java";
	private static final String SHORTCUTS_TEXT = String.format("%10s%s%s", "CTRL", "O", "Open") +
												String.format("%10s%s%s", "CTRL", "S", "Save") +
												String.format("%10s%s%s", "CTRL", "+", "Zoom In") +
												String.format("%10s%s%s", "CTRL", "-", "Zoom Out");
	private int fontSize = 15;
	private boolean isSaved = false;
	private boolean ctrlPressed = false;
	private ImageIcon appIcon;
	private JTextArea textArea;
	private JScrollPane scroll;
	private File fileToOpen;
	private File fileToSave;
	private BufferedWriter writer;
	private BufferedReader reader;
	private ButtonsPanel buttonsPanel;
	private JFileChooser fileChooser;
	private Menu menu;
	private StatusBar statusBar;
	private LineLabel lines;
	private JPanel textAndLines;
	private Scanner scan;
	private ThemeSetter themeSetter;
	private Map<Object, Runnable> actions;
	private String fileName = "";
	private String allContent = "";
	private String allWrittenText;

	public NotebookFrame(){
		initializeComponents();
		setTextAreaProperties();
		addInterfacesToComponents();
		setFrameProperties();
		addComponentsToFrame();
		setDefaultTheme();
		initializeActionsMap();
	}

	private void initializeComponents() {
		appIcon = new ImageIcon("src/main/resources/img/icon.png");
		textArea = new JTextArea();
		buttonsPanel = new ButtonsPanel();
		menu = new Menu();
		statusBar = new StatusBar();
		lines = new LineLabel();
		textAndLines = new JPanel();
		themeSetter = new ThemeSetter(this, textArea, lines, statusBar,
				statusBar.getWords(), statusBar.getSymbols(), statusBar.getWithoutSpaces(), statusBar.getParagraphs(),
				menu, menu.getFileMenu(), menu.getViewMenu(), menu.getHelpMenu(), buttonsPanel, fontSize);
	}

	private void setTextAreaProperties() {
		textArea.setFont(new Font("Arial", Font.PLAIN, fontSize));
		textArea.setBackground(new Color(211, 211, 211));
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setLineWrap(true);
		textArea.setCaretColor(Color.BLUE);
		textArea.setForeground(Color.BLACK);
		textAndLines.setLayout(new BorderLayout());
		textAndLines.add(lines, BorderLayout.WEST);
		textAndLines.add(textArea);
		scroll = new JScrollPane(textAndLines, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}

	private void addInterfacesToComponents() {
		buttonsPanel.getOpenButton().addActionListener(this);
		buttonsPanel.getSaveButton().addActionListener(this);
		buttonsPanel.getInfoButton().addActionListener(this);
		buttonsPanel.getZoomInButton().addActionListener(this);
		buttonsPanel.getZoomOutButton().addActionListener(this);
		menu.getShowLines().addActionListener(this);
		menu.getShowStatusBar().addActionListener(this);
		menu.getDarkTheme().addActionListener(this);
		menu.getClassicTheme().addActionListener(this);
		menu.getPurpleTheme().addActionListener(this);
		menu.getLightTheme().addActionListener(this);
		menu.getYellowTheme().addActionListener(this);
		menu.getHackerTheme().addActionListener(this);
		menu.getShortcuts().addActionListener(this);
		menu.getInfoMenu().addActionListener(this);
		menu.getOpenMenu().addActionListener(this);
		menu.getSaveMenu().addActionListener(this);
		menu.getExitMenu().addActionListener(this);
		textArea.addCaretListener(this);
		textArea.addKeyListener(this);
	}

	private void setFrameProperties() {
		this.setTitle("Notebook");
		this.setBounds(200, 100, 1000, 600);
		this.setResizable(true);
		this.setIconImage(appIcon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void addComponentsToFrame() {
		this.add(scroll);
		this.add(buttonsPanel, BorderLayout.NORTH);
		this.add(statusBar, BorderLayout.SOUTH);
		this.setJMenuBar(menu);
	}

	private void setDefaultTheme() {
		themeSetter.setTheme(Themes.CLASSIC);
	}

	private void initializeActionsMap(){
		actions = new HashMap<>();
		actions.put(buttonsPanel.getSaveButton(), this::saveFile);
		actions.put(menu.getSaveMenu(), this::saveFile);
		actions.put(buttonsPanel.getOpenButton(), this::openFile);
		actions.put(menu.getOpenMenu(), this::openFile);
		actions.put(buttonsPanel.getInfoButton(), () -> showInformationDialog("Notebook", INFORMATION_ABOUT_PROGRAM));
		actions.put(menu.getInfoMenu(), () -> showInformationDialog("Notebook", INFORMATION_ABOUT_PROGRAM));
		actions.put(menu.getExitMenu(), () -> System.exit(0));
		actions.put(buttonsPanel.getZoomInButton(), () -> changeFont(2));
		actions.put(buttonsPanel.getZoomOutButton(), () -> changeFont(-2));
		actions.put(menu.getShowLines(), () -> handleShowView(lines, menu.getShowLines(), "Lines"));
		actions.put(menu.getShowStatusBar(), () -> handleShowView(statusBar, menu.getShowStatusBar(), "Status Bar"));
		actions.put(menu.getShortcuts(), () -> showInformationDialog("Shortcuts", SHORTCUTS_TEXT));
		actions.put(menu.getDarkTheme(), () -> themeSetter.setTheme(Themes.DARK));
		actions.put(menu.getClassicTheme(), () -> themeSetter.setTheme(Themes.CLASSIC));
		actions.put(menu.getLightTheme(), () -> themeSetter.setTheme(Themes.LIGHT));
		actions.put(menu.getHackerTheme(), () -> themeSetter.setTheme(Themes.HACKER));
		actions.put(menu.getYellowTheme(), () -> themeSetter.setTheme(Themes.YELLOW));
		actions.put(menu.getPurpleTheme(), () -> themeSetter.setTheme(Themes.PURPLE));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var source = e.getSource();

		Runnable action = actions.get(source);
		if (action != null) {
			action.run();
		}
	}

	private void handleShowView(Component component, JMenuItem menuItem, String componentName) {
		if (!component.isVisible()) {
			component.setVisible(true);
			menuItem.setText(" ●   Show " + componentName);
		} else {
			component.setVisible(false);
			menuItem.setText("       Show " + componentName);
		}
	}

	private void showInformationDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.NO_OPTION);
	}

	public void saveFile() {
		File fileToWrite;
		if (fileName != null && !fileName.equals("")) {
			fileToWrite = fileChooser.getSelectedFile();
		} else {
			JFileChooser fileSaver = new JFileChooser();
			fileSaver.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fileSaver.showSaveDialog(null);
			fileToWrite = fileSaver.getSelectedFile();
			if (fileToWrite == null) {
				return;
			}
			fileToWrite = new File(fileSaver.getCurrentDirectory() + File.separator + fileToWrite.getName() + ".txt");
		}

		try {
			writer = new BufferedWriter(new FileWriter(fileToWrite));
			writer.write(textArea.getText());
			writer.close();
			isSaved = true;
		} catch (IOException | NullPointerException ex) {
			ex.printStackTrace();
		}
	}
	
	public void openFile() {
		if (!isSaved) {
			int answer = JOptionPane.showConfirmDialog(null, "Do you want to save the file?",
					"Save the file", JOptionPane.YES_NO_CANCEL_OPTION);
			if (answer == JOptionPane.YES_OPTION) {
				saveFile();
			}
		}

		fileChooser = new JFileChooser();
		int choice = fileChooser.showOpenDialog(null);
		if (choice == JFileChooser.APPROVE_OPTION) {
			try {
				fileToOpen = fileChooser.getSelectedFile();
				reader = new BufferedReader(new FileReader(fileToOpen));
				scan = new Scanner(fileToOpen);
				fileName = fileChooser.getSelectedFile().getName().substring(0,
						fileChooser.getSelectedFile().getName().length() - 4);

				while (scan.hasNextLine()) {
					allContent = allContent.concat(scan.nextLine() + "\n");
				}
				textArea.setText(allContent);
				reader.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		isSaved = false;
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		if(e.getSource() == textArea) {
			allWrittenText = textArea.getText();

			statusBar.getSymbols().setText(String.format("%11d SYMBOLS  |", Counter.charCount(allWrittenText)));
			statusBar.getWords().setText(String.format("%11d WORDS  |", Counter.wordCount(allWrittenText)));
			statusBar.getWithoutSpaces().setText(String.format("%11d WITHOUT WHITE SPACES  |", Counter.withoutSpacesCount(allWrittenText)));
			statusBar.getParagraphs().setText(String.format("%11d PARAGRAPHS  |", Counter.paragraphCount(allWrittenText)));
			
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

		if (ctrlPressed) {
			if (e.getKeyCode() == ZOOM_IN) {
				changeFont(2);
			} else if (e.getKeyCode() == ZOOM_OUT) {
				changeFont(-2);
			} else if (e.getKeyCode() == OPEN) {
				openFile();
			} else if (e.getKeyCode() == SAVE) {
				saveFile();
			}
			ctrlPressed = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == CTRL_KEY) {
			ctrlPressed = false;
		}
	}

	private void changeFont(int change) {
		if (fontSize + change >= 14 && fontSize + change <= 61) {
			fontSize += change;
			textArea.setFont(new Font(textArea.getFont().getFontName(), Font.PLAIN, fontSize));
			lines.setFont(new Font(lines.getFont().getFontName(), Font.PLAIN, fontSize));
		}
	}

	public int getFontSize() {
		return fontSize;
	}

	public boolean isSaved() {
		return isSaved;
	}

	public boolean isCtrlPressed() {
		return ctrlPressed;
	}

	public ImageIcon getAppIcon() {
		return appIcon;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public File getFileToOpen() {
		return fileToOpen;
	}

	public File getFileToSave() {
		return fileToSave;
	}

	public BufferedWriter getWriter() {
		return writer;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public ButtonsPanel getButtonsPanel() {
		return buttonsPanel;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public Menu getMenu() {
		return menu;
	}

	public StatusBar getStatusBar() {
		return statusBar;
	}

	public LineLabel getLines() {
		return lines;
	}

	public JPanel getTextAndLines() {
		return textAndLines;
	}

	public ThemeSetter getThemeSetter() {
		return themeSetter;
	}
}