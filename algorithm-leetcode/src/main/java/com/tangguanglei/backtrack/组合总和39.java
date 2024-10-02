package com.tangguanglei.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 组合总和39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, ans, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> ans, int index, List<Integer> path) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        path.add(candidates[index]);
        backtrack(candidates, target - candidates[index], ans, index, path);
        path.remove(path.size() - 1);

        backtrack(candidates, target, ans, index + 1, path);
    }
}
