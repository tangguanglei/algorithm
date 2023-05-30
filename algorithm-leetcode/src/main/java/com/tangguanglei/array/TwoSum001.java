package com.tangguanglei.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSum001 {

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

    public static void main(String[] args) {
        TwoSum001 twoSum001 = new TwoSum001();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum001.twoSum(nums, target);
        assert result[0] == 1 && result[1] == 0;
    }
}
