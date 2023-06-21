package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

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
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; ++i) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; ++i) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    /*public int findTheWinner(int n, int k) {
        if (n == 1) return 1;
        int ans = findTheWinner(n - 1, k) + k;
        return ans % n == 0 ? n : (ans % n);
    }*/

}
