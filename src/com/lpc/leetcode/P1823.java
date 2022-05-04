package com.lpc.leetcode;

import org.junit.Test;

/**
 * 找出游戏的获胜者
 *
 * @author byu_rself
 * @date 2022/5/4 7:57
 */
public class P1823 {

    @Test
    public void solution() {
        int n = 5;
        int k = 2;
        System.out.println(findTheWinner(n, k));
    }

    public int findTheWinner(int n, int k) {
        if (n == 1) return 1;
        int ans = findTheWinner(n - 1, k) + k;
        return ans % n == 0 ? n : (ans % n);
    }

}
