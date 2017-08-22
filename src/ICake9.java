import java.util.ArrayList;
import java.util.List;

/**
 * Created by apaswami on 3/11/17.
 */
public class ICake9 {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.insertLeft(8);
        root.insertRight(15);

        root.left.insertLeft(5);
        root.left.insertRight(9);

        root.right.insertLeft(12);
        root.right.insertRight(20);

        System.out.println(isTreeABinaryTree(root));
        System.out.println(isTreeABinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean isTreeABinaryTree(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        getList(root, list);

        int size = list.size();
        int elem = list.get(0).intValue();

        int i = 1;

        while (i < size) {
            if (list.get(i).intValue() < elem) {
                return false;
            }
            elem = list.get(i).intValue();
            i++;
        }
        return true;
    }

    public static boolean isTreeABinaryTree(BinaryTreeNode node, int lowerBound, int upperBound) {
        if (node == null) {
            return true;
        }

        return node.value > lowerBound && node.value < upperBound
                && isTreeABinaryTree(node.left, lowerBound, node.value)
                && isTreeABinaryTree(node.right, node.value, upperBound);
    }

    private static void getList(BinaryTreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        getList(node.left, list);
        list.add(node.value);
        getList(node.right, list);
    }
}
