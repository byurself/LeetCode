package com.lpc.leetcode;

/**
 * 数青蛙
 *
 * @author byu_rself
 * @date 2023/5/6 16:42
 */
public class P1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0, ans = 0;
        for (char x : croakOfFrogs.toCharArray()) {
            if (x == 'c') {
                if (k > 0) --k;
                else ++ans;
                ++c;
            } else if (x == 'r') {
                --c;
                ++r;
            } else if (x == 'o') {
                --r;
                ++o;
            } else if (x == 'a') {
                --o;
                ++a;
            } else {
                --a;
                ++k;
            }
            if (c < 0 || r < 0 || o < 0 || a < 0) return -1;
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) return -1;
        return ans;
    }
}
