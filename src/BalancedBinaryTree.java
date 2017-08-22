import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by apaswami on 3/9/17.
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(0, "a");

        Node left = root.addLeftNode("b");
        //Node right = root.addRightNode("c");

        left.addLeftNode("d");
        //left.addRightNode("e");

        //right.addLeftNode("f");
        //right.addRightNode("g");

        left.left.addLeftNode("h");
        //left.left.addRightNode("i");

        System.out.println(isTreeSuperBalanced(root));
        System.out.println(isTreeBalancedIterative(root));
    }

    public static boolean isTreeSuperBalanced(Node root) {

        int[] a = new int[2];
        parseTree(root, a, 0);

        System.out.println(a[0]);
        System.out.println(a[1]);
        return (a[1] - a[0] > 1) ? false : true;
    }

    private static void parseTree(Node n, int[] a, int d) {
        if (n == null) {
            if (d < a[0] || a[0] == 0) {
                a[0] = d;
            }
            if (d > a[1]) {
                a[1] = d;
            }
            return;
        }
        parseTree(n.left, a, d+1);
        parseTree(n.right, a, d+1);
    }

    public static boolean isTreeBalancedIterative(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        ArrayList<Integer> a = new ArrayList<>(3);

        while (!nodes.isEmpty()) {
            Node n = nodes.pop();

            if (n.left == null && n.right == null) {
                if (!a.contains(n.depth)) {
                    a.add(n.depth);

                    if (a.size() > 2 || (a.size() == 2 && Math.abs(a.get(0) - a.get(1)) > 1)) {
                        return false;
                    }
                }
            } else {
                if (n.left != null) {
                    nodes.push(n.left);
                }
                if (n.right != null) {
                    nodes.push(n.right);
                }
            }
        }

        return true;
    }

    static class Node {
        Node left;
        Node right;

        int depth;
        String val;

        public Node (int depth, String val) {
            this.depth = depth;
            this.val = val;
        }

        public Node addLeftNode(String val) {
            this.left = new Node(depth + 1, val);
            return this.left;
        }

        public Node addRightNode(String val) {
            this.right = new Node(depth + 1, val);
            return this.right;
        }
    }
}
