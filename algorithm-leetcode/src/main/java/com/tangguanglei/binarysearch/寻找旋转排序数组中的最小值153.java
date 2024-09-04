package com.tangguanglei.binarysearch;

public class 寻找旋转排序数组中的最小值153 {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        寻找旋转排序数组中的最小值153 instant = new 寻找旋转排序数组中的最小值153();
        int[] nums = new int[]{3,4,5,1,2};
        instant.findMin(nums);
    }
}
