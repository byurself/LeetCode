package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    int[][] f;
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String s;
    int n;

    public List<List<String>> partition(String s) {
        this.s = s;
        n = s.length();
        f = new int[n][n];
        dfs(0);
        return ans;
    }

    public void dfs(int i) {
        if (i == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (isPalindrome(i, j) == 1) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    // f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    private int isPalindrome(int i, int j) {
        if (f[i][j] != 0) return f[i][j];

        if (i >= j) f[i][j] = 1;
        else if (s.charAt(i) == s.charAt(j)) f[i][j] = isPalindrome(i + 1, j - 1);
        else f[i][j] = -1;

        return f[i][j];
    }

/*    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[][] f;
    String s;
    int n;

    public List<List<String>> partition(String s) {
        this.s = s;
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); ++j) {
            if (f[i][j]) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }*/

    /*List<List<String>> ans = new ArrayList<>();
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
    }*/
}
