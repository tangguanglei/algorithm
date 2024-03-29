package com.tangguanglei;

import javax.swing.plaf.SliderUI;
import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,4,5,0,0,1};
        solution.moveZeroes(nums);
    }
}
