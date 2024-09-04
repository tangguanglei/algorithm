package com.tangguanglei.binarysearch;

public class 搜索插入位置35 {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        搜索插入位置35 instant = new 搜索插入位置35();
        int[] nums = new int[] {1,3,5,6};
        instant.searchInsert(nums, 2);
    }
}
