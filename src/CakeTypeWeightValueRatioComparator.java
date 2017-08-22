import java.util.Comparator;

/**
 * Created by apaswami on 3/25/17.
 */
public class CakeTypeWeightValueRatioComparator implements Comparator<CakeTypeWithCapacity> {

    @Override
    public int compare(CakeTypeWithCapacity o1, CakeTypeWithCapacity o2) {
        double c1Ratio = o1.type.value / o1.type.weight;
        double c2Ratio = o2.type.value / o2.type.weight;

        if (c1Ratio == c2Ratio) {
            int mod1 = o1.type.weight % o1.capacity;
            int mod2 = o2.type.weight % o2.capacity;

            if (mod1 == mod2) {
                return 0;
            }
            // we need the one which is most divisible by capacity - will not work
            return (mod1 < mod2) ? -1 : 1;
        } else {
            // sort in descending order
            return (c1Ratio < c2Ratio) ? 1 : -1;
        }
    }
}
