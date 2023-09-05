package com.tangguanglei.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void insertionSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 1; i < a.length; ++i) {
            //未排序区间的值
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1,0};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
