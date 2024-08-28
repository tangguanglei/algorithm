package com.tangguanglei.hash;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longestConsecutive = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int currentNum = num;
            int currentConsecutive = 1;
            while (set.contains(currentNum + 1)) {
                currentNum += 1;
                currentConsecutive += 1;
            }
            longestConsecutive = Math.max(longestConsecutive, currentConsecutive);
        }
        return longestConsecutive;
    }
}
