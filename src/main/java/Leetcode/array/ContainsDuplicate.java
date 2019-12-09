package Leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by George Fouche on 12/8/19.
 */
public class ContainsDuplicate {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int[] arr2 = {1, 2, 3, 4};

        System.out.println(containsDuplicate(arr));
        System.out.println(containsDuplicate(arr2));
        System.out.println(containsDuplicate2(arr));
        System.out.println(containsDuplicate2(arr2));


    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    private static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums); // O(n log n) merge sort
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;

    }
}
