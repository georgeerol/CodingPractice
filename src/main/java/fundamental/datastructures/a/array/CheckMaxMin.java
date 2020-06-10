package fundamental.datastructures.a.array;

import java.util.Arrays;

/**
 * Created by George Fouche on 12/11/19.
 */
public class CheckMaxMin {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(maxMinExp1(arr)));
        System.out.println(Arrays.toString(maxMinExp2(arr2)));

    }

    private static int[] maxMinExp1(int[] arr) {
        int[] newArr = new int[arr.length];

        int pointerSmall = 0;
        int pointerLarge = arr.length - 1;

        //Flag which will help in switching between 2 pointers
        boolean switchPointer = true;

        for (int i = 0; i < arr.length; i++) {
            if (switchPointer)
                newArr[i] = arr[pointerLarge--]; // copy large value
            else
                newArr[i] = arr[pointerSmall++]; // copy small values
            switchPointer = !switchPointer;
        }
        System.arraycopy(newArr, 0, arr, 0, arr.length);
        return arr;
    }

    private static int[] maxMinExp2(int[] arr) {

        return new int[0];
    }


}
