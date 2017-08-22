/**
 * Created by apaswami on 4/19/17.
 */
public class EditDistance {

    public static int getMinEditDistance(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException();
        }

        if (str1.length() == 0) {
            return str2.length();
        } else if (str2.length() == 0) {
            return str1.length();
        }

        char[] a1 = str1.toCharArray();
        char[] a2 = str2.toCharArray();

        int[][] v = new int[a1.length + 1][a2.length + 1];

        for (int i = 1; i <= a1.length; i++) {
            v[i][0] = i;
        }

        for (int j = 1; j <= a2.length; j++) {
            v[0][j] = j;
        }

        for (int i = 1; i <= a1.length; i++) {
            for (int j = 1; j <= a2.length; j++) {
                if (a1[i - 1] == a2[j - 1]) {
                    v[i][j] = Math.min(v[i - 1][j - 1], 1 + Math.min(v[i][j - 1], v[i - 1][j]));
                } else {
                    v[i][j] = 1 + Math.min(v[i - 1][j - 1], Math.min(v[i][j - 1], v[i - 1][j]));
                }
            }
        }

        return v[a1.length][a2.length];
    }

    public static void main(String[] args) {
        System.out.println(getMinEditDistance("blue", "black"));
    }
}
