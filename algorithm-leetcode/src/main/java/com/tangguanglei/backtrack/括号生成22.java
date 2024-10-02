package com.tangguanglei.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 括号生成22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, ans, new StringBuilder(), 0, 0);
        return ans;
    }

    private void backtrack(int n, List<String> ans, StringBuilder path, int left, int right) {
        if (path.length() == 2 * n) {
            ans.add(path.toString());
            return;
        }
        if (left < n) {
            path.append("(");
            backtrack(n, ans, path, left+1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(")");
            backtrack(n, ans, path, left, right+1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        括号生成22 instace = new 括号生成22();
        System.out.println(instace.generateParenthesis(1));
    }
}
