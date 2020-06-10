package fundamental.datastructures.c.stackandqueues;

/**
 * Created by George Fouche on 12/10/19.
 */
public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public void push(int data) {
        if (isFull()) throw new RuntimeException("Stack is full");
        stackArray[++top] = data;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stackArray[top];

    }


    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }


    public static void main(String[] args) {
        Stack stack = new Stack(20);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());

    }

    String view() {
        String result = "[";
        for (int data : stackArray) {
            result += data + " ";
        }
        result += "]";
        return result;
    }

    @Override
    public String toString() {
        return view();
    }
}
