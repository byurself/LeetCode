package com.lpc.leetcode;

import java.util.PriorityQueue;

/**
 * 最长快乐字符串
 *
 * @author byu_rself
 * @date 2023/2/11 14:10
 */
public class P1405 {

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) q.offer(new int[]{0, a});
        if (b > 0) q.offer(new int[]{1, b});
        if (c > 0) q.offer(new int[]{2, c});
        StringBuilder builder = new StringBuilder();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int length = builder.length();
            if (length >= 2 && builder.charAt(length - 1) - 'a' == cur[0] && builder.charAt(length - 2) - 'a' == cur[0]) {
                if (q.isEmpty()) break;
                int[] next = q.poll();
                builder.append((char) (next[0] + 'a'));
                if (--next[1] > 0) q.offer(next);
                q.offer(cur);
            } else {
                builder.append((char) (cur[0] + 'a'));
                if (--cur[1] > 0) q.offer(cur);
            }
        }
        return builder.toString();
    }
}
