package com.tangguanglei.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 全排列46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                backtrack(nums, ans, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
