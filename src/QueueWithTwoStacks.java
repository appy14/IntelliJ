import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by apaswami on 3/26/17.
 */
public class QueueWithTwoStacks {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public void enqueue(int item) {
        inStack.push(item);
    }

    public int dequeue() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks q = new QueueWithTwoStacks();
        q.enqueue(12);
        q.enqueue(13);
        q.enqueue(15);

        System.out.println(q.dequeue());

        q.enqueue(20);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

}
