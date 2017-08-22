import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Stacks {

    public static boolean isBalanced(String expression) {
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            if (isEnclosingBracket(expression.charAt(i))) {
                s.push(expression.charAt(i));
            } else {
                if (s.isEmpty() || !isMatching(s.pop(), expression.charAt(i))) {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    private static boolean isEnclosingBracket(char c) {
        return (c == '(' || c == '{' || c == '[');
    }

    private static boolean isMatching(char c1, char c2) {
        return ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']'));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
