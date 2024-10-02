package com.tangguanglei.greedy;

public class 跳跃游戏55 {
    public boolean canJump(int[] nums) {
        int maxR = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxR) {
                maxR = Math.max(maxR, nums[i] + i);
                if (maxR >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
