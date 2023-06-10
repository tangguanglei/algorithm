package com.tangguanglei.datastruct.graph;

import java.util.Arrays;

public class DimensionalArray {

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(a[1]));
        System.out.println(a[1][2]);
        System.out.println(a.length);
    }
}
