/**
 * Created by apaswami on 3/11/17.
 */
public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int v) {
        BinaryTreeNode node = new BinaryTreeNode(v);
        this.left = node;
        return node;
    }

    public BinaryTreeNode insertRight(int v) {
        BinaryTreeNode node = new BinaryTreeNode(v);
        this.right = node;
        return node;
    }
}
