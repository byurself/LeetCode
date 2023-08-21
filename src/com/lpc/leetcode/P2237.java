package com.lpc.leetcode;

/**
 * 移动片段得到字符串
 *
 * @author byu_rself
 * @date 2023/8/21 9:25
 */
public class P2237 {

    public boolean canChange(String start, String target) {
        int n = start.length();
        for (int i = 0, j = 0; ; ++i, ++j) {
            while (i < n && start.charAt(i) == '_') ++i;
            while (j < n && target.charAt(j) == '_') ++j;
            if (i == n && j == n) return true;
            if (i == n || j == n || start.charAt(i) != target.charAt(j)) return false;
            if ((start.charAt(i) == 'L' && i < j) || (start.charAt(i) == 'R') && i > j) return false;
        }
    }
}
