package fundamental.datastructures.sort;

import java.util.Arrays;

/**
 * Created by George Fouche on 1/27/20.
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] sample1 = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(sort1(sample1)));
    }

    private static int[] sort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minimum = i;
            for (int j = i; j < array.length; j++) {
                if (array[minimum] > array[j])
                    minimum = j;
            }
            swap(i, minimum, array);
        }
        return array;
    }


    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }




}
