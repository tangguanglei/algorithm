package com.tangguanglei.dp;

public class 分割等和子集416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= target; w++) {
                if (w < nums[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        return dp[n][target] == target;
    }
}
