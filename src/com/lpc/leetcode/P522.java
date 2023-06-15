package com.lpc.leetcode;

import org.junit.Test;

/**
 * 最长特殊序列II
 *
 * @author byu_rself
 * @date 2022/6/27 12:53
 */
public class P522 {

    @Test
    public void solution() {
        String[] strs = new String[]{"aba", "cdc", "eae"};
        System.out.println(findLUSlength(strs));
    }

    public int findLUSlength(String[] strs) {
        int n = strs.length, ans = -1;
        for (int i = 0; i < n; ++i) {
            boolean flag = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans = Math.max(ans, strs[i].length());
        }
        return ans;
    }

    private boolean isSubseq(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) ++i;
            ++j;
        }
        return i == s.length();
    }
}
