package fundamental.datastructures.c.stackandqueues;


/**
 * Created by George Fouche on 1/4/20.
 */
public class QueueWithStack<I extends Number> {

    private Stack stack1;
    private Stack stack2;

    public QueueWithStack(int maxSize) {
        stack1 = new Stack(maxSize);
        stack2 = new Stack(maxSize);

    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void enqueue(int i) {
        stack1.push(i);
    }

    /**
     * 1. return null if both the stacks are empty
     * 2. If stack2 is empty, we pop all the elements from stack1 and push them to the stack2
     * 3. We return the top of stack2
     * 4. If none of the above conditions are applicable we will simply return top of stack2
     */
    private int dequeue() {
        if (isEmpty()) {
            return -1;
        } else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();

        } else {
            return stack2.pop();
        }

    }

    public static void main(String[] args) {
        QueueWithStack<Integer> queue = new QueueWithStack<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue()); //this will output -1 because queue will be empty.

    }


}
