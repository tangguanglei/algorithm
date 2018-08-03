package com.tangguanglei.primary.arrays;

/**
 * @Description: 从排序数组中删除重复项
 * @Author: tangguanglei
 * @Date: 2018/8/3 15:20
 * @Version v1.0
 **/
public class Solution1 {
    public static int removeDuplicates(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[p] != nums[i]) {
                ++p;
                nums[p] = nums[i];
            }
        }
        return ++p;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 2, 2, 3, 4, 4, 9}));
    }
}
