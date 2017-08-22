import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int[] sizes = new int[n];
            for (int sizes_i = 0; sizes_i < n; sizes_i++) {
                sizes[sizes_i] = in.nextInt();
            }
            Arrays.sort(sizes);

            int v = in.nextInt();

            int count = 0;
            int length = n;

            for (int a1 = 0; a1 < v; a1++) {
                int smallest = in.nextInt();
                int largest = in.nextInt();

                if (length > 0) {
                    // your code goes here
                    int c = findCount(sizes, smallest, largest, length);
                    length -= c;
                    count += c;
                }
            }
            System.out.println(count);
        }
    }

    public static int findCount(int[] sizes, int smallest, int largest, int n) {
        if (smallest > largest) {
            return 0;
        }
        if (largest == 13) {
            System.out.println(Arrays.toString(sizes));
        }
        int count = 0;

        int smallestIndex = findIndex(sizes, smallest, n);
        int largestIndex = findIndex(sizes, largest, n);

        while (smallestIndex < n && sizes[smallestIndex] < smallest) smallestIndex++;
        while (largestIndex >= 0 && sizes[largestIndex] > largest) largestIndex--;

        if (smallestIndex <= largestIndex) {
            count = largestIndex - smallestIndex + 1;

            int j = largestIndex + 1;
            int i = smallestIndex;

            while (j < n) {
                sizes[i++] = sizes[j++];
            }
        }
        return count;
    }

    public static int findIndex(int[] sizes, int num, int n) {
        int hi = n - 1;
        int lo = 0;

        int mid = 0;

        while (hi >= lo) {
            mid = (hi + lo) / 2;

            if (sizes[mid] == num) {
                return mid;
            }
            else if (sizes[mid] > num) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return mid;
    }

}
