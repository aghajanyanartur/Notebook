package notebook;
import static org.junit.Assert.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import javax.swing.event.CaretEvent;

public class NotebookFrameTest {
    private NotebookFrame frame;
    private JTextArea textArea;
    private JScrollPane scroll;
    private JPanel textAndLines;
    private JFileChooser fileChooser;

    @Before
    public void setUp() {
        frame = new NotebookFrame();
        textArea = frame.getTextArea();
        scroll = frame.getScroll();
        textAndLines = frame.getTextAndLines();
        fileChooser = frame.getFileChooser();
    }

    @Test
    public void testInitializeComponents() {
        assertNotNull(frame.getAppIcon());
        assertNotNull(textArea);
        assertNotNull(frame.getButtonsPanel());
        assertNotNull(frame.getMenu());
        assertNotNull(frame.getStatusBar());
        assertNotNull(frame.getLines());
        assertNotNull(textAndLines);
        assertNotNull(frame.getThemeSetter());
    }

    @Test
    public void testSetTextAreaProperties() {
        assertEquals(15, textArea.getFont().getSize());
        assertEquals(new Color(211, 211, 211), textArea.getBackground());
        assertEquals(new Insets(10, 10, 10, 10), textArea.getMargin());
        assertTrue(textArea.getLineWrap());
        assertEquals(Color.BLUE, textArea.getCaretColor());
        assertEquals(Color.BLACK, textArea.getForeground());
    }

    @Test
    public void testSetFrameProperties() {
        assertEquals("Notebook", frame.getTitle());
        assertEquals(JFrame.EXIT_ON_CLOSE, frame.getDefaultCloseOperation());
        assertTrue(frame.isResizable());
        assertEquals(0, frame.getExtendedState());
        assertTrue(frame.isVisible());
    }

    @Test
    public void testTextAreaKeyListener() {
        KeyEvent event = new KeyEvent(textArea, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'a');
        for (KeyListener listener : textArea.getKeyListeners()) {
            listener.keyPressed(event);
        }
        assertFalse(frame.isSaved());
    }
}