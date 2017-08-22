import java.util.Arrays;

/**
 * Created by apaswami on 3/26/17.
 */
public class LongestIncreasingSubsequence {

    public static int lis(int[] a) {
        if (a.length <= 1) {
            return a.length;
        }
        int[] a2 = new int[a.length];
        int max = lis(a, 0, a2);

        System.out.println(Arrays.toString(a2));

        return max;
    }

    private static int lis(int[] a, int i, int[] a2) {
        if (i == a.length - 1) {
            a2[i] = 1;
            return 1;
        }

        int lisJ = lis(a, i+1, a2);

        int lisI = 1;

        for (int j = i + 1; j < a.length; j++) {
            if (a[i] < a[j] && lisI < (a2[j] + 1)) {
                lisI = a2[j] + 1;
            }
        }
        a2[i] = lisI;

        return Math.max(lisI, lisJ);
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 50};
        System.out.println(lis(a));
    }
}
