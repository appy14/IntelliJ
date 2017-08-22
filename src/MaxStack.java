import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by apaswami on 3/26/17.
 */
public class MaxStack {
    Stack<StackNodeWithMax> stack = new Stack<>();

    public void push(int element) {
        int prevMax = (stack.isEmpty()) ? 0: stack.peek().max;

        stack.push(new StackNodeWithMax(element, (element > prevMax) ? element : prevMax));
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.pop().element;
    }

    public int getMax() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.peek().max;
    }

    class StackNodeWithMax {
        int element;
        int max;

        public StackNodeWithMax(int element, int max) {
            this.element = element;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(10);
        maxStack.push(20);
        maxStack.push(15);
        maxStack.push(25);

        System.out.println(maxStack.getMax());
        maxStack.pop();

        System.out.println(maxStack.getMax());


    }
}
