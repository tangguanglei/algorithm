package com.tangguanglei.sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {


    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(int[] a) {
        if (a.length <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < a.length; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < a.length; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[a.length];
        // 计算排序的关键步骤，有点难理解
        for (int i = a.length - 1; i >= 0; --i) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < a.length; ++i) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,4,6,9,3,5,10,11,2,8};
        countingSort(a);
        System.out.println(Arrays.toString(a));
    }
}
