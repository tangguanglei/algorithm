package com.tangguanglei.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合17 {
    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        backtrack(digits, ans, new StringBuilder(), 0);
        return ans;
    }

    private void backtrack(String digits, List<String> ans, StringBuilder path, int index) {
        if (index == digits.length()) {
            ans.add(path.toString());
            return;
        }
        String words = map.get(digits.charAt(index));
        for (int i = 0; i < words.length(); i++) {
            path.append(words.charAt(i));
            backtrack(digits, ans, path, index+1);
            path.deleteCharAt(index);
        }
    }
}
