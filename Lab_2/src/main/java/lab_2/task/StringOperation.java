package lab_2.task;

import java.lang.String;
import java.lang.StringBuilder;
import java.util.*;

public class StringOperation {
    static List<Character> delimiters = Arrays.asList(' ', ',', '.', '!', '?', ';', ':', '\n', '\t');

    // Student number: 9
    public static void countWords(StringBuilder text, StringBuilder sb){
        var words = splitStringBuilder(sb, delimiters);
        var textWords = splitStringBuilder(text, delimiters);

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        
        for (StringBuilder word : words) {
            String w = word.toString();
            int count = 0;
            for (StringBuilder tw : textWords) {
                if (w.equals(tw.toString())) {
                    count++;
                }
            }
            wordCount.put(w, count);
        }
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Student number: 4
    public static void switchFirstLastWord(StringBuilder inputStr){
        if (inputStr == null || inputStr.length() < 2) {
            System.out.println("String is too short to switch words.");
            return;
        }
        List<String> words = new ArrayList<>();
        for (StringBuilder sb : splitStringBuilder(inputStr, delimiters)) {
            words.add(sb.toString());
        }
        if (words.size() < 2) {
            System.out.println("Not enough words to switch.");
            return;
        }
        String first = words.get(0);
        String last = words.get(words.size() - 1);

        int firstStart = inputStr.indexOf(first);
        int firstEnd = firstStart + first.length();
        int lastStart = inputStr.lastIndexOf(last);
        int lastEnd = lastStart + last.length();

        StringBuilder result = new StringBuilder();
        result.append(inputStr.substring(0, firstStart));
        result.append(last);
        result.append(inputStr.substring(firstEnd, lastStart));
        result.append(first);
        result.append(inputStr.substring(lastEnd));

        System.out.println(result.toString());
    }

    public static List<StringBuilder> splitStringBuilder(StringBuilder sb, List<Character> delimiters) {
        List<StringBuilder> result = new ArrayList<>();
        int start = 0;
        for (int i = 0; i <= sb.length(); i++) {
            if (i == sb.length() || delimiters.contains(sb.charAt(i))) {
                if (start < i) {
                    result.add(new StringBuilder(sb.substring(start, i)));
                }
                start = i + 1;
            }
        }
        return result;
    }
}
