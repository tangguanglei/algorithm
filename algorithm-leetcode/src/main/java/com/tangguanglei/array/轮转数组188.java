package com.tangguanglei.array;

import java.util.Arrays;

public class 轮转数组188 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        轮转数组188 instant = new 轮转数组188();
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        instant.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
