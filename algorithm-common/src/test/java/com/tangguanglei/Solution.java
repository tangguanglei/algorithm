package com.tangguanglei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        List<Integer> ans = new ArrayList<>();
        int maxPosition = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) > maxPosition) {
                ans.add(i - maxPosition + 1);
                maxPosition = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        solution.partitionLabels(s);
    }
}
