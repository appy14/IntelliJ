/**
 * Created by apaswami on 3/26/17.
 */
public class BiggestPlusSign {

    public static int getBiggestPlusSign(int[][] a) {
        int maxSize = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int size = getMaxSize(a, i, j);
                if (size > maxSize) {
                    maxSize = size;
                }
            }
        }
        return maxSize;
    }

    public static int getMaxSize(int[][] a, int i, int j) {
        if (a[i][j] == 0 || i == 0 || j == 0) {
            return 0;
        }

        int rowLength = a.length;
        int colLength = a[0].length;

        int size = 0;

        int level = 1;

        while (i - level >= 0 && j - level >=0 && i + level < rowLength && j + level < colLength) {
            if (a[i - level][j] == 1 && a[i][j - level] == 1 && a[i + level][j] == 1 && a[i][j + level] == 1) {
                size++;
                level++;
            } else {
                break;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0, 0, 1, 0, 0, 1, 0}, {1, 0, 1, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0}};

        System.out.println(getBiggestPlusSign(a));
    }
}
