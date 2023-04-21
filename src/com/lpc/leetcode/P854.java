package com.lpc.leetcode;

import java.util.*;

/**
 * 相似度为K的字符串
 *
 * @author byu_rself
 * @date 2022/9/21 19:55
 */
public class P854 {

    int ans = Integer.MAX_VALUE;
    char[] cs1, cs2;

    public int kSimilarity(String s1, String s2) {
        cs1 =s1.toCharArray();
        cs2 = s2.toCharArray();
        return dfs(0, 0);
    }

    private int dfs(int start, int cur) {
        if (cur >= ans) return ans;
        if (start == cs1.length - 1) return ans = cur;

        for (int i = start; i < cs1.length; ++i) {
            if (cs1[i] != cs2[i]) {
                for (int j = i + 1; j < cs2.length; ++j) {
                    if (cs2[j] == cs1[i] && cs2[j] != cs1[j]) {
                        swap(cs2, i, j);
                        dfs(i + 1, cur + 1);
                        swap(cs2, i, j);
                        if (cs2[i] == cs1[j]) break;
                    }
                }
                return ans;
            }
        }
        return ans = cur;
    }

    private void swap(char[] cs, int i, int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

/*    public int kSimilarity(String s1, String s2) {
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s1);
        visited.add(s1);
        int ans = 0;
        while (true) {
            for (int i = queue.size(); i > 0; --i) {
                String s = queue.poll();
                if (s.equals(s2)) return ans;
                for (String t : next(s, s2)) {
                    if (!visited.contains(t)) {
                        visited.add(t);
                        queue.offer(t);
                    }
                }
            }
            ++ans;
        }
    }

    private List<String> next(String s, String s2) {
        int i = 0, n = s.length();
        char[] cs = s.toCharArray();

        while (cs[i] == s2.charAt(i)) ++i;

        List<String> res = new ArrayList<>();
        for (int j = i + 1; j < n; ++j) {
            if (cs[j] == s2.charAt(i) && cs[j] != s2.charAt(j)) {
                swap(cs, i, j);
                res.add(new String(cs));
                swap(cs, i, j);
            }
        }
        return res;
    }

    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }*/

    /*private int min = Integer.MAX_VALUE;

    private int kSimilarity(String s1, String s2) {
        return dfs(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    public int dfs(char[] cs1, char[] cs2, int start, int cur) {
        if (cur >= min) return min;
        if (start == cs1.length - 1) return min = Math.min(cur, min);

        for (int i = start; i < cs1.length; i++) {
            if (cs1[i] != cs2[i]) {
                for (int j = i + 1; j < cs2.length; j++) {
                    if (cs2[j] == cs1[i] && cs2[j] != cs1[j]) {
                        swap(cs2, i, j); // 交换
                        dfs(cs1, cs2, i + 1, cur + 1);
                        swap(cs2, i, j); // 回溯
                        if (cs2[i] == cs1[j]) break; // 如果cs1和cs2的i位于j位互为相等，那么就是最优交换
                    }
                }
                return min;
            }
        }
        return min = Math.min(cur, min);
    }

    private void swap(char[] sc, int i, int j) {
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
    }*/
}
