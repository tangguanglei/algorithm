package com.tangguanglei.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        //找出中间索引
        int mid = (start + end) / 2;
        //对左边数组进行递归
        sort(a, start, mid);
        //对右边数组进行递归
        sort(a, mid + 1, end);
        //合并
        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[a.length];// 临时数组
        int k = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            //从两个数组中取出较小的放入临时数组
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        //剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }
        //将临时数组中的内容拷贝回原数组中 （left-right范围的内容）
        for (int m = 0; m < k; m++) {
            a[m + start] = temp[m];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,4,6,9,3,5,10,11,2,8};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
