package com.tangguanglei.greedy;

public class 跳跃游戏II45 {
    public int jump(int[] nums) {
        int steps = 0;
        int n = nums.length - 1;
        int maxR = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            maxR = Math.max(maxR, nums[i] + i);
            if (i == end) {
                steps++;
                end = maxR;
            }
        }
        return steps;
    }
}
