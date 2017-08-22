import java.util.Arrays;

/**
 * Created by apaswami on 3/23/17.
 */
public class ICakeGirlScout {

    public static void main(String[] args) {
        int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

        System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                a3[k++] = a1[i++];
            } else {
                a3[k++] = a2[j++];
            }
        }

        while (i < a1.length) {
            a3[k++] = a1[i++];
        }

        while (j < a2.length) {
            a3[k++] = a2[j++];
        }

        return a3;
    }
}
