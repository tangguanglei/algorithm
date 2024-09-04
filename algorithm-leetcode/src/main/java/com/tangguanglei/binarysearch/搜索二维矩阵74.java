package com.tangguanglei.binarysearch;

public class 搜索二维矩阵74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, down = m - 1;
        int row = -1;
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (matrix[mid][0] <= target) {
                up = mid + 1;
                row = mid;
            } else {
                down = mid - 1;
            }
        }
        if (row < 0) {
            return false;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        搜索二维矩阵74 instant = new 搜索二维矩阵74();
        int[][] matrix = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int[][] matrix1 = new int[][]{{1}};
        System.out.println(instant.searchMatrix(matrix1, 2));
    }
}
