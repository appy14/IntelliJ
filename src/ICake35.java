import java.util.Arrays;
import java.util.Random;

/**
 * Created by apaswami on 4/21/17.
 */
public class ICake35 {

    private static int getRandom(int f, int c) {
        Random random = new Random();
        return random.nextInt(c - f + 1) + f;
    }

    public static void shuffle(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int randIndex = getRandom(i, a.length - 1);

            if (randIndex != i) {
                int tmp = a[i];
                a[i] = a[randIndex];
                a[randIndex] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5};

        shuffle(a);
        System.out.println(Arrays.toString(a));

        System.out.println(getRandom(0, 10));
    }
}
