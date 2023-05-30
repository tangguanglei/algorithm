package com.tangguanglei.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void sort(int[] a, int start, int end) {
        if (start >= end)
            return;
        int pivot = partition(a, start, end);
        sort(a, start, pivot - 1);
        sort(a, pivot + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp = a[i];
        a[i] = a[end];
        a[end] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] a = {1,4,6,9,3,5,10,11,2,8};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
