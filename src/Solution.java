import java.util.*;

public class Solution {

    static final int MAX_LENGTH = 5;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] p = new long[n];

        int i = 0;
        while (i < n) {
            p[i] = sc.nextLong();
            i++;
        }

        // long[] p = new long[]{5, 10, 3, 6, 20, 18, 14, 12, 13, 22, 7};
        System.out.println(findMinLoss(p));

    }

    public static long findMinLoss(long[] p) {
        long[] s = new long[p.length];

        long minLoss = Long.MAX_VALUE;
        s[0] = p[0];

        int numSegments = 1;

        for (int i = 1; i < p.length; i++) {

            long nextGreaterVal = findNextGreaterVal(s, p[i], i - 1, numSegments);

            if (nextGreaterVal > p[i]) {
                long loss = nextGreaterVal - p[i];
                System.out.println("loss: " + loss);
                if (loss < minLoss) {
                    minLoss = loss;
                }
            }
            numSegments = i / MAX_LENGTH + 1;
            insert(s, p[i], i, numSegments - 1);
        }
        System.out.println(Arrays.toString(s));
        return minLoss;
    }

    private static long findNextGreaterVal(long[] s, long num, int i, int numSegments) {

        long maxVal = 0;

        for (int j = 1; j <= numSegments; j++) {
            int segEnd = j * MAX_LENGTH - 1;
            int endOfCurrentArray = (i > segEnd) ? segEnd : i;
            int hi = endOfCurrentArray;
            int lo = 0;
            int mid = 0;
            while (hi >= lo) {
                mid = (hi + lo) / 2;
                if (s[mid] == num) {
                    break;
                } else if (num > s[mid]) {
                    lo = mid + 1;
                } else if (num < s[mid]) {
                    hi = mid - 1;
                }
            }

            while (mid <= endOfCurrentArray && s[mid] <= num) {
                mid++;
            }
            long diff = s[mid] - num;

            if (maxVal == 0 || (diff > 0 && diff < maxVal - num)) {
                maxVal = s[mid];
            }
            System.out.println(maxVal);
        }
        return maxVal;
    }

    private static void insert(long[] s, long num, int i, int segment) {
        int segBeginning = segment * MAX_LENGTH;

        if (i != segBeginning) {
            int j = i - 1;
            while (j >= segBeginning && s[j] > num) {
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = num;
        } else {
            s[i] = num;
        }
    }
}
