import java.util.Arrays;

/**
 * Created by apaswami on 3/12/17.
 */
public class SomeClass {

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 6, 1, 3, 4, 5, 6, 7, 10, 11, 12};
        sortBasedOnOutput(a);

        System.out.println(Arrays.toString(a));
    }

    public static void sortBasedOnOutput(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int tmp = function(a[i]);
            int num = a[i];

            while (j >= 0 && function(a[j]) > tmp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = num;
        }
    }

    private static int function(int num) {
        return num % 3;
    }
}
