/**
 * Created by apaswami on 3/22/17.
 */
public class ICake13 {

    public static void main(String[] args) {
        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote" // <-- rotates here!
        };

        System.out.println(findRotationPoint(words));
    }

    public static int findRotationPoint(String[] a) {
        if (a.length <= 1) {
            return a.length;
        }

        int hi = a.length - 1;
        int lo = 0;

        if (a.length == 2) {
            if (a[hi].compareTo(a[lo]) > 0) {
                return lo;
            } else {
                return hi;
            }
        }

        while (hi >= lo) {
            if (a[lo].compareTo(a[hi]) <= 0) {
                return lo;
            }

            int mid = (lo + hi) / 2;

            if (a[mid].compareTo(a[mid-1]) < 0 && a[mid].compareTo(a[mid + 1]) < 0) {
                return mid;
            }

            if (a[mid].compareTo(a[lo]) < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
