/**
 * Created by apaswami on 4/21/17.
 */
public class ICake36 {

    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] sd) {
        int h1 = 0;
        int h1Max = half1.length - 1;

        int h2 = 0;
        int h2Max = half2.length - 1;

        for (int i = 0; i < sd.length; i++) {
            if (h1 <= h1Max && sd[i] == half1[h1]) {
                h1++;
            } else if (h2 <= h2Max && sd[i] == half2[h2]) {
                h2++;
            } else {
                return false;
            }
        }

        return true;
    }
}
