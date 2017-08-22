import java.util.NoSuchElementException;

/**
 * Created by apaswami on 4/8/17.
 */
public class ICake25 {

    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {
        if (head == null || k <= 0) {
            throw new IllegalArgumentException("Head is null or k is lesser than 0");
        }

        LinkedListNode plusKNode = head;

        int indexPlusK = 0;

        while (plusKNode != null && indexPlusK < k) {
            plusKNode = plusKNode.next;
            indexPlusK++;
        }

        if (indexPlusK < k) {
            throw new NoSuchElementException();
        }

        LinkedListNode kthToLastNode = head;

        while (plusKNode != null) {
            plusKNode = plusKNode.next;
            kthToLastNode = kthToLastNode.next;
        }

        return kthToLastNode;
    }

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode(1);
        LinkedListNode b = new LinkedListNode(2);
        LinkedListNode c = new LinkedListNode(3);
        LinkedListNode d = new LinkedListNode(4);
        LinkedListNode e = new LinkedListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(kthToLastNode(1, a).value);
    }
}
