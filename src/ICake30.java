import java.util.HashSet;
import java.util.Set;

/**
 * Created by apaswami on 3/24/17.
 */
public class ICake30 {

    public static void main(String[] args) {
        System.out.println(isPermutationAPalindrome("malayalam"));
        System.out.println(isPermutationAPalindrome2("ivicc"));
    }

    public static boolean isPermutationAPalindrome(String s) {
        int[] c = new int[26];

        int numOdd = 0;

        int length = s.length();

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            c[index] = c[index] + 1;
        }

        for (int i = 0; i < 26; i++) {
            if (c[i] > 0) {
                if ((c[i] % 2) != 0) {
                    numOdd++;
                }
            }
        }

        if ((length % 2) == 0) {
            if (numOdd != 0) {
                return false;
            }
        } else if (numOdd != 1){
            return false;
        }
        return true;
    }

    public static boolean isPermutationAPalindrome2(String s) {
        Set<Character> characterSet = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (characterSet.contains(s.charAt(i))) {
                characterSet.remove(s.charAt(i));
            } else {
                characterSet.add(s.charAt(i));
            }
        }
        return characterSet.size() <= 1;
    }
}
