/**
 * Created by apaswami on 4/12/17.
 */
public class ICake27 {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        char[] c = s.toCharArray();

        int i = 0;
        int j = s.length() - 1;

        int wordBegIndex = i;
        int wordEndIndex = j;

        while (i < j) {

            char tmp = c[i];
            c[i] = c[j];

            c[j] = tmp;

            if (c[i] == ' ') {
                reverseWord(c, wordBegIndex, i - 1);
                wordBegIndex = i + 1;
            }

            if (c[j] == ' ') {
                reverseWord(c, j + 1, wordEndIndex);
                wordEndIndex = j - 1;
            }

            i++;
            j--;
        }

        reverseWord(c, wordBegIndex, wordEndIndex);

        return new String(c);
    }

    private static void reverseWord(char[] c, int si, int ei) {
        while (si < ei) {
            char tmp = c[si];
            c[si++] = c[ei];
            c[ei--] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("find you will pain only go you recordings security the into if"));
    }
}
