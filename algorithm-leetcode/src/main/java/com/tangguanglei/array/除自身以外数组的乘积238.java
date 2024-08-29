package com.tangguanglei.array;

import java.util.Arrays;

public class 除自身以外数组的乘积238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                L[0] = 1;
            } else {
                L[i] = nums[i - 1] * L[i - 1];
            }
        }
        int[] R = new int[n];
        for (int j = n - 1; j >= 0; j--) {
            if (j == n - 1) {
                R[n - 1] = 1;
            } else {
                R[j] = nums[j + 1] * R[j + 1];
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        除自身以外数组的乘积238 instant = new 除自身以外数组的乘积238();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(instant.productExceptSelf(nums)));
    }
}
