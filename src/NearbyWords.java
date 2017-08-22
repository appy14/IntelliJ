import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by apaswami on 4/20/17.
 */
public class NearbyWords {

    public static Set<String> getNearbyWords(String s) {
        if (s == null || s.trim() == "") {
            throw new IllegalArgumentException();
        }

        Set<String> nearbyWords = new HashSet<>();
        getNearbyWords(s, nearbyWords, 0);

        return nearbyWords;
    }

    private static void getNearbyWords(String s, Set<String> nearbyWords, int index) {
        if (index >= s.length()) {
            return;
        }
        getNearbyWords(s, nearbyWords, index + 1 );

        Set<Character> nearbyChars = getNearbyChars(s.charAt(index));

        Set<String> newWords = new HashSet<>();
        for (Character c : nearbyChars) {
            for (String nearbyWord : nearbyWords) {
                newWords.add(String.format("%s%c%s", nearbyWord.substring(0, index), c, nearbyWord.substring(index + 1)));
            }
            newWords.add(String.format("%s%c%s", s.substring(0, index), c, s.substring(index + 1)));
        }
        nearbyWords.addAll(newWords);
    }

    private static Set<Character> getNearbyChars(char c) {
        Map<Character, Set<Character>> charsMap = new HashMap<>();
        charsMap.put('h', new HashSet<Character>());
        charsMap.get('h').add('g');
        charsMap.get('h').add('j');
        charsMap.get('h').add('h');

        charsMap.put('i', new HashSet<Character>());
        charsMap.get('i').add('o');
        charsMap.get('i').add('u');
        charsMap.get('i').add('i');

        return charsMap.get(c);
    }

    public static void main(String[] args) {
        Set<String> nearbyWords = getNearbyWords("hi");
        for (String s : nearbyWords) {
            System.out.println(s);
        }
    }
}
