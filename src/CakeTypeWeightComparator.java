import java.util.Comparator;

/**
 * Created by apaswami on 3/25/17.
 */
public class CakeTypeWeightComparator implements Comparator<CakeType> {

    @Override
    public int compare(CakeType o1, CakeType o2) {
        if (o1.weight == o2.weight) {
            return 0;
        }
        return (o1.weight < o2.weight) ? -1 : 1;
    }
}
