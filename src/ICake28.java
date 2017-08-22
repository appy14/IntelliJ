import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by apaswami on 4/12/17.
 */
public class ICake28 {

    public static int getMatchingParanthesesPos(String s, int openPos) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        Stack<Paranthetical> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(new Paranthetical('(', i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    throw new NoSuchElementException();
                }
                Paranthetical p = stack.pop();
                if (p.pos == openPos) {
                    return i;
                }
            }
        }

        throw new NoSuchElementException();
    }

    public static int getMatchingParanthesesPos2(String s, int openPos) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        int countOfPAtOpenPos = 0;

        if (s.charAt(openPos) == '(') {
            int count = 1;
            for (int i = openPos + 1; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    count++;
                } else if (s.charAt(i) == ')') {
                    count--;
                    if (count == 0) {
                        return i;
                    }
                }
            }
        }
        throw new NoSuchElementException();
    }

    public static void main(String[] args) {
        String s = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        System.out.println(getMatchingParanthesesPos(s, 10));
        System.out.println(getMatchingParanthesesPos2(s, 10));
    }

    static class Paranthetical {
        char type;
        int pos;

        Paranthetical(char type, int pos) {
            this.type = type;
            this.pos = pos;
        }
    }
}
