package fundamental.datastructures.sort;

import java.util.Arrays;

/**
 * Created by George Fouche on 1/27/20.
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] sample1 = {8, 5, 2, 9, 5, 6, 3};
        int[] sample2 = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(sort(sample1)));
        System.out.println(Arrays.toString(sort2(sample2)));


    }


    private static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int toInsert = array[i];
            while (j > 0 && array[j - 1] > toInsert) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = toInsert;
        }
        return array;
    }


    private static int[] sort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                swap(j, j - 1, array);
                j--;
            }
        }
        return array;
    }

    private static void swap(int j, int i, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j]= temp;
    }


}
