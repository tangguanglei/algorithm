package com.tangguanglei.skill;

import java.util.Arrays;

public class 多数元素169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
