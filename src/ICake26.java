/**
 * Created by apaswami on 4/8/17.
 */
public class ICake26 {

    public static String doInPlaceStringReversal(String s) {
        if (s == null || s.trim().length() == 0) {
            throw new IllegalArgumentException();
        }

        char[] a = s.trim().toCharArray();

        for (int i = 0, j = a.length - 1; i < a.length/2; i++, j--) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        return new String(a);
    }

    public static void main(String[] args) {
        System.out.println(doInPlaceStringReversal("world"));
        System.out.println(doInPlaceStringReversal("aparna"));
    }
}
