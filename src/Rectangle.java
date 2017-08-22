/**
 * Created by apaswami on 3/5/17.
 */
public class Rectangle {
    Integer leftX;
    Integer bottomY;

    Integer width;
    Integer height;

    public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width = width;
        this.height = height;
    }

    public Rectangle() {}

    @Override
    public String toString() {
        return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
    }
}
