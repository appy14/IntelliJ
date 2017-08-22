import java.util.HashSet;
import java.util.Set;

/**
 * Created by apaswami on 4/12/17.
 */
public class ICake31 {

    public static Set<String> getPermutations(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        if (s.length() == 1) {
            Set<String> permutations = new HashSet<String>(1);
            permutations.add(s);
            return permutations;
        }

        Set<String> permutations = new HashSet<String>();

        for (String permutation : getPermutations(s.substring(1))) {
            int endIndex = permutation.length() - 1;
            char c = s.charAt(0);
            permutations.add(String.format("%c%s", c, permutation));
            for (int i = 1; i <= endIndex; i++) {
                permutations.add(String.format("%s%c%s", permutation.substring(0, i), c, permutation.substring(i)));
            }
            permutations.add(String.format("%s%c", permutation, c));
        }

        return permutations;
    }

    public static void main(String[] args) {
        Set<String> permutations = getPermutations("abcdefghi");

        for (String s : permutations) {
            System.out.println(s);
        }
        System.out.println(permutations.size());
    }
}
