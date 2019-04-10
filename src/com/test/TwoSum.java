package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 * @author duanzhiwei {@link https://leetcode-cn.com/problems/two-sum/}
 */
public class TwoSum {
    /**
     * @param numbers:
     *            An array of Integer
     * @param target:
     *            target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { 0, 0 };
    }

    /**
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            throw new IllegalArgumentException("No two sum solution");
        }
        // key:需要匹配的数字，即target-nums[i]，value:第几个数
        Map<Integer, Integer> sums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (sums.containsKey(nums[i])) {
                return new int[] { i, sums.get(nums[i]) };
            }
            sums.put(target - nums[i], i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum clazz = new TwoSum();
        System.out.println(clazz.twoSum1(new int[] { 0, 4, 3, 0 }, 0));
    }
}