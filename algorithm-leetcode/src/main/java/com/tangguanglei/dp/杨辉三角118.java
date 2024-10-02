package com.tangguanglei.dp;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角118 {
    public List<List<Integer>> generate(int numRows) {
        //阶段划分&定义状态
        int[][] dp = new int[numRows][numRows];
        //边界条件
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        //状态转移
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < numRows - 1; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(dp[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}
