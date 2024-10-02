package com.tangguanglei.dp;

public class 打家劫舍198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] money = new int[n];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
        }
        return money[n - 1];
    }
}
