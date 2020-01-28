package fundamental.datastructures.sort;

import java.util.Arrays;

/**
 * Created by George Fouche on 1/24/20.
 */
public class BubbleSort {


    public static void main(String[] args) {

        int[] sample1 = {8, 5, 2, 9, 5, 6, 3};
        int[] sample2 = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(sort1(sample1)));
        System.out.println(Arrays.toString(sort2(sample2)));


    }

    /**
     *
     * @param array
     * @return
     */
    private static int[] sort1(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                }
            }
        }
        return array;
    }

    private static int[] sort2(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;

    }

}
