package com.tangguanglei.greedy;

public class 买卖股票的最佳时机121 {
    public int maxProfit(int[] prices) {
        int in = Integer.MAX_VALUE;
        int out = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            in = Math.min(prices[i], in);
            out = Math.max(out, prices[i] - in);
        }
        return out <= 0 ? 0 : out;
    }
}
