package com.tangguanglei.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 子集78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> path, int index) {
        ans.add(new ArrayList<>(path));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, ans, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
