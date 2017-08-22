/**
 * Created by apaswami on 3/25/17.
 */
public class CakeTypeWithCapacity {
    CakeType type;
    int capacity;

    public CakeTypeWithCapacity(CakeType type, int capacity) {
        if (type == null || capacity < 0) {
            throw new IllegalArgumentException("Either type is null or capacity is non-zero");
        }
        this.type = type;
        this.capacity = capacity;
    }
}
