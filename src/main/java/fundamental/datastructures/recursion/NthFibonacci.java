package fundamental.datastructures.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by George Fouche on 1/23/20.
 */
public class NthFibonacci {

    public static void main(String[] args) {
        System.out.println(getNthFib(10));
        System.out.println(getNthFibWithMemoize(10));
        System.out.println(getNthFibwhithLastTwo(10));

    }

    /**
     * Formula: Fib(n) = Fib(n-1) + Fib(n-2) for n > 2
     * Time: O(2^n) | Space: O(n)
     *
     * @param n
     * @return
     */
    private static int getNthFib(int n) {
        if (n == 2) return 1;
        if (n == 1) return 0;

        return getNthFib(n - 1) + getNthFib(n - 2);
    }


    /**
     * If  n : memoize:
     * return memoize[n]
     * else
     * memoize = fib(n-1) + fib(n-2)
     */

    private static int getNthFibWithMemoize(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return getNthFibWithMemoize(n, memoize);
    }

    private static int getNthFibWithMemoize(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        } else {
            memoize.put(n, getNthFib(n - 1) + getNthFib(n - 2));
            return memoize.get(n);
        }

    }

    private static int getNthFibwhithLastTwo(int n) {

        int[] lastTwo = {0, 1};
        int count = 3;

        while (count <= n) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            count++;
        }

        return n > 1 ? lastTwo[1] : lastTwo[0];

    }

}
