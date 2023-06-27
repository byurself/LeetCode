package com.lpc.leetcode;

/**
 * 消除游戏
 *
 * @author byu_rself
 * @date 2023/6/27 16:18
 */
public class P390 {

    public int lastRemaining(int n) {
        int head = 1, step = 1;
        boolean left = true;
        while (n > 1) {
            if (left || n % 2 != 0) {
                head += step;
            }
            step *= 2;
            left = !left;
            n /= 2;
        }
        return head;
    }
}
