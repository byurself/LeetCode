package com.lpc.leetcode;

/**
 * 强密码检验器
 *
 * @author byu_rself
 * @date 2023/7/10 9:30
 */
public class P420 {

    public int strongPasswordChecker(String password) {
        char[] cs = password.toCharArray();
        int n = cs.length;
        int A = 0, B = 0, C = 0;
        for (char c : cs) {
            if (c >= 'a' && c <= 'z') A = 1;
            else if (c >= 'A' && c <= 'Z') B = 1;
            else if (c >= '0' && c <= '9') C = 1;
        }
        int m = A + B + C;
        if (n < 6) {
            return Math.max(6 - n, 3 - m);
        } else if (n <= 20) {
            int total = 0;
            for (int i = 0; i < n; ) {
                int j = i;
                while (j < n && cs[j] == cs[i]) ++j;
                int cnt = j - i;
                if (cnt >= 3) total += cnt / 3;
                i = j;
            }
            return Math.max(total, 3 - m);
        } else {
            int total = 0;
            int[] cnts = new int[3];
            for (int i = 0; i < n; ) {
                int j = i;
                while (j < n && cs[j] == cs[i]) ++j;
                int cnt = j - i;
                if (cnt >= 3) {
                    total += cnt / 3;
                    ++cnts[cnt % 3];
                }
                i = j;
            }
            int base = n - 20, cur = base;
            for (int i = 0; i < 3; ++i) {
                if (i == 2) cnts[i] = total;
                if (cnts[i] != 0 && cur != 0) {
                    int t = Math.min(cnts[i] * (i + 1), cur);
                    cur -= t;
                    total -= t / (i + 1);
                }
            }
            return base + Math.max(total, 3 - m);
        }
    }
}
