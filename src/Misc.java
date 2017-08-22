import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by apaswami on 3/26/17.
 */
public class Misc {

    public static int findUniqueDeliveryId(int[] deliveryIds) {
        int uniqueDeliveryId = 0;

        for (int deliveryId : deliveryIds) {
            uniqueDeliveryId ^= deliveryId;
        }

        return uniqueDeliveryId;
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    public static void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        quicksort(a, 0, a.length - 1);
    }

    private static void quicksort(int[] a, int lo, int hi) {
        if (hi < lo) {
            return;
        }

        int i = lo;
        int j = hi;

        int pivot = a[lo + (hi - lo)/2];

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;

                i++;
                j--;
            }
        }

        quicksort(a, lo, j);
        quicksort(a, i, hi);

    }

    public static void main(String[] args) {
        int[] d = new int[]{10, 11, 10, 5, 6, 6, 11};
        System.out.println(findUniqueDeliveryId(d));

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        inOrderTraversal(root);

        System.out.println("-----------");
        int[] a = new int[]{10, 34, 12, 4, 67};
        sort(a);
        System.out.println(Arrays.toString(a));

        System.out.println("-------");
        System.out.println(isValidNumber("1.00"));

        List<Integer> a1 = new ArrayList<>();
        a1.add(10);
        a1.add(13);

        List<Integer> a2 = new ArrayList<>();
        a2.add(11);
        a2.add(14);

        List<Integer> a3 = new ArrayList<>();
        a3.add(12);
        a3.add(15);

        interleavedListInterator(a1, a2, a3);
    }

    public static boolean isValidNumber(String s) {
        Pattern p = Pattern.compile("-?(0|[1-9][0-9]*)(.[0-9]+)?");

        Matcher m = p.matcher(s);

        return m.matches();
    }

    public static void interleavedListInterator(List<Integer> a1, List<Integer> a2, List<Integer> a3) {
        List<Iterator<Integer>>  iterators = new ArrayList<>();

        int notEmptyCount =  0;

        if (a1.size() > 0) {
            iterators.add(a1.iterator());
            notEmptyCount++;
        }
        if (a2.size() > 0) {
            iterators.add(a2.iterator());
            notEmptyCount++;
        }
        if (a3.size() > 0) {
            iterators.add(a3.iterator());
            notEmptyCount++;
        }

        int currIndex = 0;

        while (notEmptyCount > 0) {
            if (iterators.get(currIndex).hasNext()) {
                System.out.println(iterators.get(currIndex).next());
            } else {
                notEmptyCount--;
            }
            currIndex = (currIndex + 1) % iterators.size();
        }
    }
}
