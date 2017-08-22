/**
 * Created by apaswami on 3/26/17.
 */
public class BinarySearch {

    public static int binarySearchIterative(int[] a, int item) {
        if (a.length == 0) {
            return -1;
        }

        int hi = a.length - 1;
        int lo = 0;

        while (hi >= lo) {
            int mid = lo + (hi - lo)/2;

            if (a[mid] == item) {
                return mid;
            }
            if (a[mid] < item) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] a, int item) {
        return search(a, item, a.length - 1, 0);
    }

    private static int search(int[] a, int item, int hi, int lo) {
        if (hi < lo) {
            return -1;
        }

        int mid = lo + (hi - lo)/2;
        if (a[mid] == item) {
            return mid;
        }
        if (a[mid] < item) {
            return search(a, item, hi, mid + 1);
        } else {
            return search(a, item, mid - 1, lo);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] a2 = new int[]{1, 2, 3, 4, 5, 6};

        System.out.println(binarySearchIterative(a, 3));
        System.out.println(binarySearchIterative(a2, 3));

        System.out.println(binarySearchIterative(a, 7));
        System.out.println(binarySearchIterative(a2, 7));

        System.out.println(binarySearchRecursive(a, 4));
        System.out.println(binarySearchRecursive(a2, 4));

        System.out.println(binarySearchRecursive(a, 8));
        System.out.println(binarySearchRecursive(a2, 10));
    }
}
