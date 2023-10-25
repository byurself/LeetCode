package com.lpc.leetcode;

/**
 * 求一个整数的惩罚数
 *
 * @author byu_rself
 * @date 2023/10/25 10:02
 */
public class P2698 {

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int x = i * i;
            if (check(x + "", 0, i)) ans += x;
        }
        return ans;
    }

    private boolean check(String s, int i, int target) {
        int m = s.length();
        if (i >= m) return target == 0;
        int x = 0;
        for (int j = i; j < m; ++j) {
            x = x * 10 + (s.charAt(j) - '0');
            if (x > target) return false;
            if (check(s, j + 1, target - x)) return true;
        }
        return false;
    }
}
