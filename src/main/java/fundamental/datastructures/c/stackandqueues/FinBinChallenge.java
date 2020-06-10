package fundamental.datastructures.c.stackandqueues;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by George Fouche on 12/10/19.
 */
public class FinBinChallenge {


    public static void main(String[] args) {

        String[] output = findBin(5);
        for (int i = 0; i < 5; i++)
            System.out.print(output[i] + " ");
    }


    /**
     * 1. Start with Enqueuing 1.
     * 2. Dequeue a number from queue and append 0 to it and enqueue it back to queue
     * 3. Perform step2 but with appending 1 to the original number and enqueue back to queue
     * Size of Queue should be 1 more than number because for a single number we're enqueing two
     *
     * @param number
     * @return
     */
    private static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < number; i++) {
            result[i] = queue.remove();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.add(s1);
            queue.add(s2);

        }

        return result;
    }
}

