package com.tangguanglei;

import java.util.Arrays;

public class SortTest {
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void insertionSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
    }

    public static void selectionSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(nums, i, min);
            }
        }
    }

    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[nums.length];
        int k = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        if (k >= 0) System.arraycopy(temp, 0, nums, start, k);
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    public static void buildHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length - 1, i);
        }
    }

    public static void heapify(int[] nums, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && nums[i] < nums[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && nums[maxPos] < nums[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(nums, i, maxPos);
            i = maxPos;
        }
    }

    public static void heapSort(int[] nums) {
        int n = nums.length;
        buildHeap(nums);
        int k = n - 1;
        while (k >= 0) {
            swap(nums, 0, k);
            k--;
            heapify(nums, k, 0);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] a = {1,8,2,6,3,4,5,7,9};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
