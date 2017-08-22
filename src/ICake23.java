/**
 * Created by apaswami on 3/23/17.
 */
public class ICake23 {

    public static boolean containsCycle(LinkedListNode start) {

        LinkedListNode slowRunner = start;
        LinkedListNode fastRunner = start.next;

        while(fastRunner != null && slowRunner != null) {
            if (slowRunner == fastRunner) {
                return true;
            }
            slowRunner = slowRunner.next;
            if (fastRunner.next != null) {
                fastRunner = fastRunner.next.next;
            }
        }

        return false;
    }
}
