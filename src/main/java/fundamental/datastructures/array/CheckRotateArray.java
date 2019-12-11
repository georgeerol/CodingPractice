package fundamental.datastructures.array;

import java.util.Arrays;

/**
 * Created by George Fouche on 12/7/19.
 */
public class CheckRotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(rotateArrayExp1(arr)));
    }

    private static int[] rotateArrayExp1(int[] nums) {
        int k = 1;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        return nums;
    }

}
