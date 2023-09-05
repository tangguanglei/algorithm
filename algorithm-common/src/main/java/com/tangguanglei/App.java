package com.tangguanglei;

import java.util.Arrays;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        int[] a = {2,3,1,2,4,2,3};
//        quickSort(a,0, a.length -1);
        System.out.println(jump(a));
        Stack<Character> stack = new Stack<>();
        stack.peek();
    }


    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static void bubbleSort(int[] a) {
        if (a == null) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                    flag = true;
                }
            }
            if (!flag) break;;
        }
    }

    public static void insertionSort(int[] a) {
        if (a == null) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int val = a[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if (a[j] > val) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = val;
        }
    }

    public static void selectionSort(int[] a) {
        if (a == null) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(a, i, min);
            }
        }
    }

    public static void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid+1, end);
        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[a.length];
        int k = 0;
        int i = start;
        int j = mid+1;
        while (i<=mid&&j<=end) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i<=mid) {
            tmp[k++] = a[i++];
        }
        while (j <= end) {
            tmp[k++] = a[j++];
        }
        for (int l = 0; l < k; l++) {
            a[start+l] = tmp[l];
        }
    }

    public static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = divition(a, start, end);
        quickSort(a, start, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    private static int divition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, end);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
