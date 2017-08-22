import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by apaswami on 3/25/17.
 */
public class ICake16KnapSack {

    public static int maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {

        int[] solution = new int[capacity + 1];

        Arrays.sort(cakeTypes, new CakeTypeWeightComparator());

        solution[0] = 0;

        for (CakeType cakeType : cakeTypes) {
            int weight = cakeType.weight;
            int value = cakeType.value;

            for (int i = weight; i <= capacity; i++) {
                if (value + solution[i - weight] > solution[i]) {
                    solution[i] = value + solution[i - weight];
                }
            }
        }
        return solution[capacity];
    }

    public static void main(String[] args) {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(7, 220),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };

        int capacity = 20;

        System.out.println(maxDuffelBagValue(cakeTypes, capacity));
    }
}
