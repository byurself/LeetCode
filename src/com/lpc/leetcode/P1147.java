package com.lpc.leetcode;

import org.junit.Test;

/**
 * 段式回文
 *
 * @author byu_rself
 * @date 2023/4/12 14:26
 */
public class P1147 {

    @Test
    public void solution() {
        System.out.println(longestDecomposition("elvtoelvto"));
    }

    public int longestDecomposition(String text) {
        int ans = 0;
        while (!text.isEmpty()) {
            int i = 1, n = text.length();
            while (i <= n / 2 && !text.substring(0, i).equals(text.substring(n - i))) ++i;
            if (i > n / 2) { // 无法分割
                ++ans;
                break;
            }
            ans += 2;
            text = text.substring(i, n - i);
        }
        return ans;
    }

    public int longestDecomposition1(String text) {
        if (text.isEmpty()) return 0; // 若分割为空字符串，返回0
        int n = text.length();
        for (int i = 1; i <= n / 2; ++i) {
            // 若前后缀相等，则立刻分割
            if (text.substring(0, i).equals(text.substring(n - i))) {
                return longestDecomposition(text.substring(i, n - i)) + 2;
            }
        }
        return 1; // 无法分割
    }
}
