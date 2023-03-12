package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 *
 * @author byu_rself
 * @date 2023/3/12 14:51
 */
public class P131 {

    @Test
    public void solution() {
        String s = "aab";
        System.out.println(partition(s));
    }

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); ++j) {
            if (isPalindrome(i, j)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
