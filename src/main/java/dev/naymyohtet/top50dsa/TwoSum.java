package dev.naymyohtet.top50dsa;

import java.util.Arrays;

/**
 * Find indices of the two numbers in an array that add up to a target.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums =  { 2, 7, 11, 15 };
        int target = 9;
        System.out.println("Result: " + Arrays.toString(twoSumBrute(nums, target)));
    }

    public static int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };

    }
}
