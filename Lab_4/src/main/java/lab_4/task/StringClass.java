package lab_4.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single letter.
 */
class Letter {
    private char value;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }
}

/**
 * Represents a word, which is an array of letters.
 */
class Word {
    private Letter[] letters;

    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    public Letter[] getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter l : letters) sb.append(l);
        return sb.toString();
    }
}

/**
 * Represents a punctuation mark.
 */
class Punctuation {
    private char mark;

    public Punctuation(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return Character.toString(mark);
    }
}

/**
 * Represents a sentence, which consists of words and punctuation marks.
 */
class Sentence {
    private List<Word> words = new ArrayList<>();
    private List<Punctuation> punctuations = new ArrayList<>();

    public Sentence(String sentence) {
        String[] parts = sentence.split("(?=[,.!?;:])|\\s+");
        for (String part : parts) {
            if (part.length() == 1 && ",.!?;:".indexOf(part.charAt(0)) >= 0) {
                punctuations.add(new Punctuation(part.charAt(0)));
            } else if (!part.isBlank()) {
                words.add(new Word(part));
            }
        }
    }

    public List<Word> getWords() {
        return words;
    }

    public List<Punctuation> getPunctuations() {
        return punctuations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int w = 0, p = 0;
        for (int i = 0; i < words.size() + punctuations.size(); i++) {
            if (w < words.size()) {
                sb.append(words.get(w++));
                if (w < words.size()) sb.append(" ");
            }
            if (p < punctuations.size()) {
                sb.append(punctuations.get(p++));
            }
        }
        return sb.toString();
    }
}

/**
 * Represents a text, which consists of sentences.
 */
class Text {
    private List<Sentence> sentences = new ArrayList<>();

    public Text(String text) {
        // Replace multiple spaces/tabs with a single space
        text = text.replaceAll("[ \\t]+", " ");
        // Split into sentences by . ! ?
        String[] sentenceArr = text.split("(?<=[.!?])\\s+");
        for (String s : sentenceArr) {
            if (!s.isBlank()) {
                sentences.add(new Sentence(s.trim()));
            }
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : sentences) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
    }
}

/**
 * Main class with executable method.
 */
public class StringClass {
    public static int countWords(Text text) {
        int count = 0;
        for (Sentence s : text.getSentences()) {
            count += s.getWords().size();
        }
        return count;
    }

    public static void countWords(Text text, List<Word> searchWords) {
        List<Word> allWords = new ArrayList<>();
        for (Sentence s : text.getSentences()) {
            allWords.addAll(s.getWords());
        }
        for (Word search : searchWords) {
            int count = 0;
            for (Word w : allWords) {
                if (w.toString().equals(search.toString())) {
                    count++;
                }
            }
            System.out.println(search + ": " + count);
        }
    }

    public static String switchFirstLastWord(Text text) {
        if (text.getSentences().isEmpty()) return "";
        Sentence s = text.getSentences().get(0);
        List<Word> words = s.getWords();
        if (words.size() < 2) return s.toString();
        Word first = words.get(0);
        Word last = words.get(words.size() - 1);
        words.set(0, last);
        words.set(words.size() - 1, first);
        return s.toString();
    }

    public static List<Word> splitWords(Text text) {
        List<Word> allWords = new ArrayList<>();
        for (Sentence s : text.getSentences()) {
            allWords.addAll(s.getWords());
        }
        return allWords;
    }
}
