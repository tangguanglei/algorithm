package com.tangguanglei.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum1 {

    //solution 1
    public int[] twoSum(int[] nums, int target) {
        //define a map to save nums and indices in array
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            arrMap.put(nums[i], i);
        }
        //loop the array to calc the target
        for (int j = 0; j < nums.length; j++) {
            int k = target - nums[j];
            if (arrMap.containsKey(k) && j != arrMap.get(k)) {
                return new int[]{arrMap.get(k), j};
            }
        }
        return null;
    }

    //solution 2
    public int[] twoSum1(int[] nums, int target) {
        //define a map to save nums and indices in array
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (arrMap.containsKey(k) && arrMap.get(k) != i) {
                return new int[] {i, arrMap.get(k)};
            }
            arrMap.put(nums[i], i);
        }
        return null;
    }
}
