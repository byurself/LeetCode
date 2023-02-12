package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * IPO
 *
 * @author byu_rself
 * @date 2023/2/12 20:15
 */
public class P502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> list = new ArrayList<>();
        int n = profits.length;
        for (int i = 0; i < n; i++) {
            list.add(new int[]{capital[i], profits[i]});
        }
        list.sort((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        while (k-- > 0) {
            while (i < n && list.get(i)[0] <= w) q.offer(list.get(i++)[1]);
            if (q.isEmpty()) break;
            w += q.poll();
        }
        return w;
    }
}
