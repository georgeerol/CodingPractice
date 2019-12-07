package datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by George Fouche on 12/6/19.
 */
public class CheckRemoveEven {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 10, 6, 3};
        System.out.println(Arrays.toString(removeEvenExp1(arr)));
        System.out.println(Arrays.toString(removeEvenExp2(arr)));

    }

    private static int[] removeEvenExp2(int[] arr) {
        int oddElements = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) oddElements++;
        }

        int[] result = new int[oddElements];
        int resultIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 !=0)result[resultIndex++] = arr[i];
        }

        return result;
    }

    private static int[] removeEvenExp1(int[] arr) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result.add(arr[i]);
            }
        }
        int[] newArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            newArr[i] = result.get(i);
        }
        return newArr;
    }
}

