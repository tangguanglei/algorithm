package com.tangguanglei.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[] {entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
