import java.util.Arrays;

/**
 * Created by apaswami on 3/25/17.
 */
public class MergeSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (hi + lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int[] a2 = Arrays.copyOf(a, a.length);

        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (i <= mid && j <= hi) {
            if (a2[i] <= a2[j]) {
                a[k] = a2[i];
                i++;
            } else {
                a[k] = a2[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            a[k++] = a2[i++];
        }

        while (j <= hi) {
            a[k++] = a2[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{20, 10, 50, 30, 60, 40};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
