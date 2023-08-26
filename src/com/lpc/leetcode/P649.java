package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Dota2参议院
 *
 * @author byu_rself
 * @date 2023/8/26 16:23
 */
public class P649 {

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Integer> rd = new ArrayDeque<>(), dd = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') rd.offer(i);
            else dd.offer(i);
        }
        while (!rd.isEmpty() && !dd.isEmpty()) {
            int a = rd.poll(), b = dd.poll();
            if (a < b) rd.offer(a + n);
            else dd.offer(b + n);
        }
        return !rd.isEmpty() ? "Radiant" : "Dire";
    }
}
