/**
 * Created by apaswami on 3/24/17.
 */
public class ICake24 {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(10);
        head.next = new LinkedListNode(20);
        head.next.next = new LinkedListNode(30);
        head.next.next.next = new LinkedListNode(40);

        LinkedListNode head2 = reverseALinkedList(head);

        while (head2 != null) {
            System.out.println(head2.value);
            head2 = head2.next;
        }
    }

    public static LinkedListNode reverseALinkedList(LinkedListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode n1 = null;
        LinkedListNode n2 = head;
        LinkedListNode n3;

        while (n2 != null) {
            n3 = n2.next; // b, c, null
            n2.next = n1; // a->null, b->a, c->b
            n1 = n2; // a, b, c
            n2 = n3; // b, c, null
        }

        return n1;
    }
}
