package com.tangguanglei.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void selectionSort(int[] a) {
        if (a == null || a.length <= 1) return;

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,4,6,9,3,5,10,11,2,8};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
