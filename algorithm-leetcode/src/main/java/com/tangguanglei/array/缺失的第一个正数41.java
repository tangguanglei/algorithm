package com.tangguanglei.array;

public class 缺失的第一个正数41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        缺失的第一个正数41 instant = new 缺失的第一个正数41();
        int[] nums = new int[] {7, 8, 9, 11, 12};
        instant.firstMissingPositive(nums);
    }
}
