/**
 * Created by apaswami on 3/25/17.
 */
public class ICake15Fibonacci {

    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be lesser than zero");
        }
        int[] f = new int[2];

        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i <=n ; i++) {
            int tmp = f[1];
            f[1] = f[0] + f[1];
            f[0] = tmp;
        }

        return f[1];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
    }
}
