package com.tangguanglei.substring;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 滑动窗口最大值239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        PriorityQueue<int[]> maxQ = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
        int left = 0, right = 0;
        while (right < nums.length) {
            maxQ.offer(new int[]{nums[right], right});
            if (right - left + 1 >= k) {
                while (maxQ.peek()[1] > right || maxQ.peek()[1] < left) {
                    maxQ.poll();
                }
                ans[left] = maxQ.peek()[0];
                left++;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        滑动窗口最大值239 instance = new 滑动窗口最大值239();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        instance.maxSlidingWindow(nums, 3);
    }
}
