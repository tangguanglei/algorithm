package com.tangguanglei.binarysearch;

public class 在排序数组种查找元素的第一个和最后一个位置34 {

    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false) - 1;
        if (start <= end && end < nums.length && nums[start] == target && nums[end] == target) {
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean isStart) {
        int left = 0, right = nums.length - 1, index = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (isStart && nums[mid] >= target)) {
                right = mid - 1;
                index = mid;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        在排序数组种查找元素的第一个和最后一个位置34 instant = new 在排序数组种查找元素的第一个和最后一个位置34();
        int[] nums = new int[]{1};
        instant.searchRange(nums, 1);
    }
}
