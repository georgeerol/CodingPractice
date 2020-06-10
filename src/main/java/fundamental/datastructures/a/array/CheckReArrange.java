package fundamental.datastructures.a.array;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Created by George Fouche on 12/11/19.
 */
public class CheckReArrange {

    public static void main(String[] args) {
        int[] arr = {2, 4, -6, 8, -5, -10};
        //out.println(Arrays.toString(reArrangeExp1(arr)));
        out.println(Arrays.toString(reArrangeExp2(arr)));
    }

    /**
     * Using New Array
     *
     * @param arr
     * @return
     */
    private static int[] reArrangeExp1(int[] arr) {
        int[] newArray = new int[arr.length];
        int newArray_index = 0;

        for (int num : arr) if (num < 0) newArray[newArray_index++] = num;
        for (int num : arr) if (num > 0) newArray[newArray_index++] = num;
        arraycopy(newArray, 0, arr, 0, newArray_index);
        return arr;
    }

    private static int[] reArrangeExp2(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
        return arr;
    }


}
