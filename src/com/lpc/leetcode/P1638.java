package com.lpc.leetcode;

/**
 * 统计只差一个字符的子串数目
 *
 * @author byu_rself
 * @date 2023/3/27 20:46
 */
public class P1638 {

    public int countSubstrings(String s, String t) {
        int ans = 0, n = s.length(), m = t.length();
        for (int d = 1 - m; d < n; ++d) {
            int i = Math.max(d, 0);
            for (int k0 = i - 1, k1 = k0; i < n && i - d < m; ++i) {
                if (s.charAt(i) != t.charAt(i - d)) {
                    k0 = k1;
                    k1 = i;
                }
                ans += k1 - k0;
            }
        }
        return ans;
    }

    // 枚举
    public int countSubstrings1(String s, String t) {
        int m = s.length(), n = t.length(), ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s.charAt(i) != t.charAt(j)) {
                    int l = 0, r = 0;
                    while (i - l > 0 && j - l > 0 && s.charAt(i - l - 1) == t.charAt(j - l - 1)) ++l;
                    while (i + r + 1 < m && j + r + 1 < n && s.charAt(i + r + 1) == t.charAt(j + r + 1)) ++r;
                    ans += (l + 1) * (r + 1);
                }
            }
        }
        return ans;
    }
}
