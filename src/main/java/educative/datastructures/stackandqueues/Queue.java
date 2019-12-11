package educative.datastructures.stackandqueues;

/**
 * Created by George Fouche on 12/10/19.
 */
public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;


    private Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    private void enqueue(int data) {
        if (rear == maxSize - 1) rear = -1;
        queueArray[++rear] = data;
        nItems++;
    }

    private int dequeue() {
        int temp = queueArray[front];
        if (++front == maxSize) front = 0;
        nItems--;
        return temp;
    }

    boolean isEmpty() {
        return nItems == 0;
    }


    private int peek() {
        return queueArray[front];
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }


    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Peek:");
        System.out.println(queue.peek());
        System.out.println("Dequeue:");
        while (!queue.isEmpty()) System.out.print(queue.dequeue() + " ");


    }

    String view() {
        String result = "[";
        for (int data : queueArray) {
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
