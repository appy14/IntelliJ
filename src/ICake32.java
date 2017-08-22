import java.util.Arrays;

/**
 * Created by apaswami on 4/17/17.
 */
public class ICake32 {

    public static void sortInLessThanNLogN(int[] a, int highestPossibleScore) {
        int[] a2 = new int[highestPossibleScore + 1];

        for (int score : a) {
            a2[score] += 1;
        }

        int index = 0;
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2[i]; j++) {
                a[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {9, 9, 1, 2, 4, 7, 8};
        sortInLessThanNLogN(a, 10);

        System.out.println(Arrays.toString(a));
    }
}
