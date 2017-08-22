/**
 * Created by apaswami on 3/5/17.
 */
public class Ex6 {
    public static Rectangle getLoveRectangle(Rectangle r1, Rectangle r2) {
        int xIntersection = -1;
        if (r1.leftX <= r2.leftX) {
            xIntersection = findXIntersection(r1, r2);
        } else {
            xIntersection = findXIntersection(r2, r1);
        }

        if (xIntersection != -1) {
            int yIntersection = -1;
            yIntersection = (r1.bottomY <= r2.bottomY) ? findYIntersection(r1, r2) : findYIntersection(r2, r1);
            if (yIntersection != -1) {
                int width = (r1.leftX <= r2.leftX) ? findWidth(r1, r2) : findWidth(r2, r1);
                int height = (r1.bottomY <= r2.bottomY) ? findHeight(r1, r2) : findHeight(r2, r1);

                return new Rectangle(xIntersection, yIntersection, width, height);
            }
        }
        return null;
    }

    private static int findXIntersection(Rectangle r1, Rectangle r2) {
        if (r2.leftX <= r1.leftX + r1.width) {
            return r2.leftX;
        }
        return -1;
    }

    private static int findYIntersection(Rectangle r1, Rectangle r2) {
        return (r2.bottomY <= r1.bottomY + r2.height) ? r2.bottomY : -1;
    }

    private static int findWidth(Rectangle r1, Rectangle r2) {
        int rightX1 = r1.leftX + r1.width;
        int rightX2 = r2.leftX + r2.width;

        if (rightX1 > rightX2) {
            return r2.width;
        } else {
            return rightX1 - r2.leftX;
        }
    }

    private static int findHeight(Rectangle r1, Rectangle r2) {
        int topY1 = r1.bottomY + r1.height;
        int topY2 = r2.bottomY + r2.height;

        if (topY1 > topY2) {
            return r2.height;
        } else {
            return topY1 - r2.bottomY;
        }
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1, 2, 4, 5);
        Rectangle r2 = new Rectangle(3, 1, 4, 10);
        System.out.println(getLoveRectangle(r1, r2));
    }
}
