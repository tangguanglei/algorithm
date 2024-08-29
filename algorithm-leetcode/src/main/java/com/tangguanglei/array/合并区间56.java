package com.tangguanglei.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (list.isEmpty() || list.get(list.size() - 1)[1] < intervals[i][0]) {
                list.add(intervals[i]);
            } else if (list.get(list.size() - 1)[1] > intervals[i][0] && list.get(list.size() - 1)[1] < intervals[i][1]){
                list.get(list.size() - 1)[1] = intervals[i][1];
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        合并区间56 instant = new 合并区间56();
        int[][] intervals = new int[][] {{1,3}, {2,6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.toString(instant.merge(intervals)));
    }
}
