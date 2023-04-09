package com.lpc.leetcode;

/**
 * 检查相同字母间的距离
 *
 * @author byu_rself
 * @date 2023/4/9 10:17
 */
public class P2399 {

    public boolean checkDistances(String s, int[] distance) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j) && distance[s.charAt(i) - 'a'] != j - i - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkDistances1(String s, int[] distance) {
        int n = s.length();
        int[] d = new int[26];
        for (int i = 0; i < n; ++i) {
            int index = s.charAt(i) - 'a';
            if (d[index] > 0 && i - d[index] != distance[index]) {
                return false;
            }
            d[index] = i + 1;
        }
        return true;
    }
}
