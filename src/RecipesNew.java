import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by apaswami on 3/17/17.
 */
public class RecipesNew {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int r = in.nextInt();
            int p = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            int[] pantry = new int[m];
            for (int pantry_i = 0; pantry_i < m; pantry_i++) {
                pantry[pantry_i] = in.nextInt();
            }
            int[] cost = new int[p];
            for (int cost_i = 0; cost_i < p; cost_i++) {
                cost[cost_i] = in.nextInt();
            }
            int[][] recipe = new int[r][p];
            for (int recipe_i = 0; recipe_i < r; recipe_i++) {
                for (int recipe_j = 0; recipe_j < p; recipe_j++) {
                    recipe[recipe_i][recipe_j] = in.nextInt();
                }
            }
            System.out.println(getMinCost(recipe, pantry, cost, n));
        }
    }

    public static int getMinCost(int[][] recipe, int[] pantry, int[] cost, int n) {
        boolean[] availablePantry = new boolean[cost.length];

        for (int i : pantry) {
            availablePantry[i] = true;
        }

        int[][] recipeByCost = new int[recipe.length][3];


        for (int i = 0; i < recipe.length; i++) {
            int costForThisRecipe = 0;
            int ingredientsInBinary = 0;

            for (int j = 0; j < recipe[i].length; j++) {
                if (availablePantry[j]) {
                    continue;
                }
                if (recipe[i][j] == 1) {
                    ingredientsInBinary |= (1 << j);
                    costForThisRecipe += cost[j];
                }
            }
            recipeByCost[i][0] = costForThisRecipe;
            recipeByCost[i][1] = ingredientsInBinary;
        }

        sortRecipe(recipeByCost);

        int minCost = findNCost(0, n, recipeByCost, cost);

        for (int count = n; count < recipe.length; count++) {
            int tmpCost = findNCost(count - n + 1, n, recipeByCost, cost);
            if (tmpCost >= minCost) {
                break;
            }
            minCost = tmpCost;
        }

        return minCost;
    }

    private static void sortRecipe(int[][] recipeByCost) {
        for (int i = 1; i < recipeByCost.length; i++) {
            int j = i - 1;
            int cost = recipeByCost[i][0];
            int b = recipeByCost[i][1];

            while (j >= 0 && recipeByCost[j][0] > cost) {
                recipeByCost[j + 1][0] = recipeByCost[j][0];
                recipeByCost[j + 1][1] = recipeByCost[j][1];
                j--;
            }
            recipeByCost[j + 1][0] = cost;
            recipeByCost[j + 1][1] = b;
        }
    }

    private static int findNCost(int count, int n, int[][] recipeByCost, int[] cost) {
        int minCost = 0;
        int boughtTillNow = 0;

        int index = 0;
        while (index < n) {
            int notBought = ~boughtTillNow;
            int toBuy = notBought & recipeByCost[count][1];

            if (toBuy == recipeByCost[count][1]) {
                minCost += recipeByCost[count][0];
            } else {
                int i = 0;
                while (toBuy > 0) {
                    if ((toBuy & 1) == 1) {
                        minCost += cost[i];
                    }
                    toBuy = (toBuy >> 1);
                    i++;
                }
            }
            boughtTillNow |= recipeByCost[count][1];
            count++;
            index++;
        }
        return minCost;
    }
}
