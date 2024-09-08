package com.tangguanglei.matrix;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            up++;
            if (up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                ans.add(matrix[down][i]);
            }
            down--;
            if (down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        螺旋矩阵54 solution = new 螺旋矩阵54();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        solution.spiralOrder(matrix);
    }
}
