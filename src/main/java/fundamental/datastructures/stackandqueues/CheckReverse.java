package fundamental.datastructures.stackandqueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by George Fouche on 1/3/20.
 */
public class CheckReverse {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        reverseK(queue, 3);

        System.out.print("Queue: ");
        while(!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }

    private static void reverseK(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k <= 0)
            return;

       Stack stack = new Stack(k);

        while(!stack.isFull()){
            stack.push(queue.remove());
        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }

        int size =queue.size();
        for(int i =0; i <size -k; i++){
            queue.add(queue.remove());
        }
    }
}
