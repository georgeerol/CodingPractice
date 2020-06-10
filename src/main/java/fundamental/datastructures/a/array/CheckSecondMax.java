package fundamental.datastructures.a.array;

import java.util.Arrays;

/**
 * Created by George Fouche on 12/7/19.
 */
public class CheckSecondMax {

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 6};
        System.out.println(findSecondMaximumExp1(arr));
        System.out.println(findSecondMaximumExp2(arr));
        System.out.println();
    }

    /**
     * Time Complexity: O(n)
     * @param arr
     * @return
     */
    private static int findSecondMaximumExp1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        for (int i : arr) {
            if (i > secondMax && i != max) {
                secondMax = i;
            }
        }
        return secondMax;
    }

    private static int findSecondMaximumExp2(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }
}
