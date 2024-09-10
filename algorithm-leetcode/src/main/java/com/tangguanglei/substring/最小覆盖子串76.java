package com.tangguanglei.substring;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串76 {

    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, ansL = -1, ansR = 0, len = Integer.MAX_VALUE, sLen = s.length();
        while (right < sLen) {
            if (ori.containsKey(s.charAt(right))) {
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (ori.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
            right++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            char k = entry.getKey();
            int count = entry.getValue();
            if (cnt.getOrDefault(k, 0) < count) {
                return false;
            }
        }
        return true;
    }
}
