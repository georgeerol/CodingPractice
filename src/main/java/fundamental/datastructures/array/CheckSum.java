package fundamental.datastructures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by George Fouche on 12/6/19.
 * https://leetcode.com/problems/two-sum/
 * Find Two Numbers that Add up to "n"
 */
public class CheckSum {

    public static void main(String[] args) {
        int[]arr = {1,21,3,14,5,60,7,6};
        int value = 27;

        System.out.println(Arrays.toString(findSumExp1(arr,value)));
    }

    /**
     * Time Complexity: O(n) as the whole array is iterated over once
     * @param arr
     * @param value
     * @return
     */
    private static int[] findSumExp1(int[] arr, int value) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i =0; i <arr.length;i++){
            int temp = value -arr[i];
            if(map.containsKey(temp)){
                return new int[]{arr[map.get(temp)],arr[i]};
            }else{
                map.put(arr[i],i);
            }
        }
        return new int[0];
    }

}
