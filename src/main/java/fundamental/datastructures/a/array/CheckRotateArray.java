package fundamental.datastructures.a.array;

import java.util.Arrays;

/**
 * Created by George Fouche on 12/7/19.
 */
public class CheckRotateArray {

    public static void main(String[] args) {
        int[] arr1= {1, 2, 3, 4, 5};
        int[] arr2= {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(rotateArrayExp1(arr1,1)));
        System.out.println(Arrays.toString(rotateArrayExp2(arr2)));
    }

    private static int[] rotateArrayExp1(int[] arr,int k) {
        int[] tempArray = new int[arr.length];
        for(int i =0; i< arr.length;i++){
            tempArray[(i+k) % arr.length] = arr[i];
        }
        for(int i = 0; i<arr.length;i++){
            arr[i] = tempArray[i];
        }

        return arr;

    }

    private static int[] rotateArrayExp2(int[] nums) {
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
