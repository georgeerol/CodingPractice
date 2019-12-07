package datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by George Fouche on 12/6/19.
 */
public class CheckMergeArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 6, 7, 8};

        System.out.println(Arrays.toString(mergeArraysExp1(arr1, arr2)));
        System.out.println(Arrays.toString(mergeArraysExp2(arr1, arr2)));
    }

    private static int[] mergeArraysExp1(int[] arr1, int[] arr2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            arrayList.add(arr1[i]);
            arrayList.add(arr2[i]);
        }
        Collections.sort(arrayList);

        int[] result = new int[arrayList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

    private static int[] mergeArraysExp2(int[] arr1, int[] arr2) {
        int s1 = arr1.length;
        int s2 = arr2.length;

        int[] arr3 = new int[s1 + s2];
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i < s1 && j < s2) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        //Store remaining elements of first array
        while (i < s1) {
            arr3[k++] = arr1[i++];
        }

        // Store remaining elements of second array
        while (j < s2) {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }


}
