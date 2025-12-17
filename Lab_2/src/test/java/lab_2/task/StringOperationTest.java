// Java
package lab_2.task;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.lang.StringBuilder;

import static org.junit.jupiter.api.Assertions.*;

public class StringOperationTest {

    @Test
    void testSplitStringBuilder_MultipleDelimiters() {
        StringBuilder sb = new StringBuilder("Hello, world! How are you?");
        List<Character> delimiters = Arrays.asList(' ', ',', '.', '!', '?', ';', ':', '\n', '\t');
        List<StringBuilder> result = invokeSplitStringBuilder(sb, delimiters);

        assertEquals(5, result.size());
        assertEquals("Hello", result.get(0).toString());
        assertEquals("world", result.get(1).toString());
    }

    @Test
    void testSplitStringBuilder_NoDelimiters() {
        StringBuilder sb = new StringBuilder("HelloWorld");
        List<Character> delimiters = Arrays.asList(' ', ',', '.', '!', '?', ';', ':', '\n', '\t');
        List<StringBuilder> result = invokeSplitStringBuilder(sb, delimiters);

        assertTrue(result.size() == 1);
    }

    @Test
    void testSplitStringBuilder_ConsecutiveDelimiters() {
        StringBuilder sb = new StringBuilder("Hello,,world!!");
        List<Character> delimiters = Arrays.asList(' ', ',', '.', '!', '?', ';', ':', '\n', '\t');
        List<StringBuilder> result = invokeSplitStringBuilder(sb, delimiters);

        assertEquals(2, result.size());
        assertEquals("Hello", result.get(0).toString());
        assertEquals("world", result.get(1).toString());
    }

    @Test
    void testSplitStringBuilder_DelimitersAtStartEnd() {
        StringBuilder sb = new StringBuilder(",Hello world!");
        List<Character> delimiters = Arrays.asList(' ', ',', '.', '!', '?', ';', ':', '\n', '\t');
        List<StringBuilder> result = invokeSplitStringBuilder(sb, delimiters);

        assertEquals(2, result.size());
        assertEquals("Hello", result.get(0).toString());
    }

    @Test
    void testSplitStringBuilder_EmptyString() {
        StringBuilder sb = new StringBuilder("");
        List<Character> delimiters = Arrays.asList(' ', ',', '.', '!', '?', ';', ':', '\n', '\t');
        List<StringBuilder> result = invokeSplitStringBuilder(sb, delimiters);

        assertTrue(result.isEmpty());
    }

    private List<StringBuilder> invokeSplitStringBuilder(StringBuilder sb, List<Character> delimiters) {
        try {
            var method = StringOperation.class.getDeclaredMethod("splitStringBuilder", StringBuilder.class, List.class);
            method.setAccessible(true);
            return (List<StringBuilder>) method.invoke(null, sb, delimiters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}