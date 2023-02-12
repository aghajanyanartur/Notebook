package notebook;

import org.junit.Test;
import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void testCharCount() {
        assertEquals(0, Counter.charCount(null));
        assertEquals(0, Counter.charCount(""));
        assertEquals(5, Counter.charCount("Hello"));
    }

    @Test
    public void testWordCount() {
        assertEquals(0, Counter.wordCount(null));
        assertEquals(0, Counter.wordCount(""));
        assertEquals(2, Counter.wordCount("Hello World"));
        assertEquals(1, Counter.wordCount("  Hello  "));
    }

    @Test
    public void testWithoutSpacesCount() {
        assertEquals(0, Counter.withoutSpacesCount(null));
        assertEquals(0, Counter.withoutSpacesCount(""));
        assertEquals(10, Counter.withoutSpacesCount("Hello World"));
        assertEquals(5, Counter.withoutSpacesCount("  Hello  "));
    }

    @Test
    public void testParagraphCount() {
        assertEquals(0, Counter.paragraphCount(null));
        assertEquals(0, Counter.paragraphCount(""));
        assertEquals(2, Counter.paragraphCount("Hello\nWorld"));
        assertEquals(1, Counter.paragraphCount("  Hello  "));
    }
}