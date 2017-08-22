import java.util.*;

/**
 * Created by apaswami on 4/12/17.
 */
public class ICake29 {

    public static boolean areParanthesesNested(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        Map<Character, Character> map = new HashMap<Character, Character>(3) {
            {
                put('}', '{');
                put(')', '(');
                put(']', '[');
            }
        };

        Set<Character> openingParantheses = new HashSet<>(3);
        openingParantheses.add('{');
        openingParantheses.add('(');
        openingParantheses.add('[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (openingParantheses.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c = stack.pop();
                if (map.get(s.charAt(i)) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(areParanthesesNested("{ [ ] ( ) }"));
        System.out.println(areParanthesesNested("{ [ ( ] ) }"));
        System.out.println(areParanthesesNested("{ [ }"));
    }
}
