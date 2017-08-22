/**
 * Created by apaswami on 4/19/17.
 */
public class MinDistance {

    public static int getMinDistance(int[][] cost, int m, int n) {
        if (cost == null) {
            throw new IllegalArgumentException();
        }

        int[][] min = new int[cost.length][cost[0].length];

        min[0][0] = cost[0][0];

        for (int i = 1; i < cost.length; i++) {
            min[i][0] = cost[i - 1][0] + cost[i][0];
        }

        for (int j = 1; j < cost[0].length; j++) {
            min[0][j] = cost[0][j - 1] + cost[0][j];
        }

        for (int i = 1; i < cost.length; i++) {
            for (int j = 1; j < cost[i].length; j++) {
                min[i][j] = Math.min(min[i - 1][j - 1], Math.min(min[i - 1][j], min[i][j - 1])) + cost[i][j];
            }
        }

        return min[m][n];
    }

    public static void main(String[] args) {
        int[][] c = new int[][] {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};

        System.out.println(getMinDistance(c, 2, 2));
    }
}
