import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by apaswami on 3/12/17.
 */
public class Recipes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int r = in.nextInt();
            int p = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            int[] pantry = new int[m];
            for(int pantry_i=0; pantry_i < m; pantry_i++){
                pantry[pantry_i] = in.nextInt();
            }
            int[] cost = new int[p];
            for(int cost_i=0; cost_i < p; cost_i++){
                cost[cost_i] = in.nextInt();
            }
            int[][] recipe = new int[r][p];
            for(int recipe_i=0; recipe_i < r; recipe_i++){
                for(int recipe_j=0; recipe_j < p; recipe_j++){
                    recipe[recipe_i][recipe_j] = in.nextInt();
                }
            }
            // your code goes here
            sortRecipesByCost(recipe, cost, pantry);
        }
    }

    public static void sortRecipesByCost(int[][] recipe, int[] cost, int[] pantry) {
        int[] output = new int[recipe.length];
        int[] ingredientsInBinary = new int[recipe.length];

        boolean[] pantryByRecipe = new boolean[cost.length];

        for (int i = 0; i < pantry.length; i++) {
            pantryByRecipe[pantry[i]] = true;
        }

        //System.out.println(Arrays.toString(cost));

        for (int i = 0; i < recipe.length; i++) {
            int totalCost = 0;
            for (int j = 0; j < recipe[i].length; j++) {
                if (pantryByRecipe[j]) {
                    ingredientsInBinary[i] |= (0 << (recipe[i].length - j));
                    continue;
                }
                ingredientsInBinary[i] |= (recipe[i][j] << (recipe[i].length - j));
                totalCost += (recipe[i][j] * cost[j]);
            }
            output[i] = totalCost;
        }

        for (int i = 1; i < output.length; i++) {
            int j = i - 1;
            int tmp = output[i];

            int tmpIngredient = ingredientsInBinary[i];

            while (j >= 0 && output[j] > tmp) {
                output[j + 1] = output[j];
                ingredientsInBinary[j + 1] = ingredientsInBinary[j];
                j--;
            }
            output[j + 1] = tmp;
            ingredientsInBinary[j + 1] = tmpIngredient;
        }

        System.out.println(Arrays.toString(output));
        System.out.println(Arrays.toString(ingredientsInBinary));
    }

    static class GraphNode {
        List<Edge> vertices;

        int recipeNumber;

        public GraphNode(int recipeNumber) {
            this.recipeNumber = recipeNumber;
        }

        public void addDirectedEdge(int weight, GraphNode node2) {
            if (vertices == null) {
                vertices = new ArrayList<Edge>();
            }
            vertices.add(new Edge(weight, node2));
        }
    }

    static class Edge {
        int weight;
        GraphNode node;

        public Edge(int weight, GraphNode node) {
            this.weight = weight;
            this.node = node;
        }
    }
}
