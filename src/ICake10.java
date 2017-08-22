/**
 * Created by apaswami on 3/11/17.
 */
public class ICake10 {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.insertLeft(5);
        //root.insertRight(15);

        root.left.insertLeft(3);
        //root.left.insertRight(6);

        //root.right.insertLeft(12);
        //root.right.insertRight(20);

        BinaryTreeNode secondLargest = findSecondLargestElement(root);

        if (secondLargest != null) {
            System.out.println(secondLargest.value);
        }
    }
    public static BinaryTreeNode findSecondLargestElement(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return null;
        }
        if (node.right == null) {
            // find rightmost element in left subtree
            return findTheLargestElement(node.left);
        } else {
            BinaryTreeNode parent = node;
            while (parent.right.right != null) {
                parent = parent.right;
            }
            BinaryTreeNode largestElement = parent.right;

            if (largestElement.left != null) {
                // find rightmost element in left subtree
                return findTheLargestElement(largestElement.left);
            } else {
                return parent;
            }
        }
    }

    public static BinaryTreeNode findTheLargestElement(BinaryTreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
