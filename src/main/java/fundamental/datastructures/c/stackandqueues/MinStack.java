package fundamental.datastructures.c.stackandqueues;

/**
 * Created by George Fouche on 1/8/20.
 */
public class MinStack {
    int maxSize;
    Stack mainStack;
    Stack minStack;


    public MinStack(int maxSize) {
        this.maxSize = maxSize;
        mainStack = new Stack(maxSize);
        minStack = new Stack(maxSize);

    }


    private void push(int value) {
        mainStack.push(value);
        if(!minStack.isEmpty() && minStack.peek() < value)
            minStack.push(minStack.peek());
        else
            minStack.push(value);

    }


    private int min() {
        return minStack.peek();
    }

    private int pop() {
        minStack.pop();
        return mainStack.pop();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack(6);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(9);

        System.out.println(stack.min());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.min());
    }


}
