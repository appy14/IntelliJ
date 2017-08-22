import java.util.NoSuchElementException;

/**
 * Created by apaswami on 4/17/17.
 */
public class ICake33 {

    public static int getNonUniqueNumber(int[] a) {
        int uniquenessBit = 0;

        for (int num : a) {
            if ((uniquenessBit & (1 << num)) > 0) {
                return num;
            }
            uniquenessBit |= (1 << num);
        }
        throw new NoSuchElementException();
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 10, 2, 3, 8, 10, 7};
        System.out.println(getNonUniqueNumber(a));
    }
}
