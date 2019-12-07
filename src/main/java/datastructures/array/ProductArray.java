package datastructures.array;

import java.util.Arrays;

/**
 *
 * Array of Products of All Elements Except Itself
 * Created by George Fouche on 12/6/19.
 */
public class ProductArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        System.out.println(Arrays.toString(findProduct(arr)));
    }

    private static int[] findProduct(int[] arr) {
        int n = arr.length;
        int i, temp =1;

        int result[] = new int[n];

        //Initializing the result array by 1
        for(int j =0; j<n;j++){
            result[j] =1;
        }


        return new int[0];
    }
}
