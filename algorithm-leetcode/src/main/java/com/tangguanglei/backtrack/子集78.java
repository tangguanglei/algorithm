package com.tangguanglei.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 子集78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : result) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            result.addAll(newSubsets);
        }
        return result;
    }

    public static void main(String[] args) {
        子集78 solution = new 子集78();
        System.out.println(solution.subsets(new int[]{1,2,3}));
    }
}
