package com.tangguanglei.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    // 冒泡排序，a表示数组
    public static void bubbleSort(int[] a) {
        if (a == null || a.length <= 1) return;

        for (int i = 0; i < a.length; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    public static void main(String[] args) {
        int[] a = {1,4,6,9,3,5,10,11,2,8};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
