package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 喧闹和富有
 *
 * @author byu_rself
 * @date 2023/4/12 19:47
 */
public class P851 {

    int N = 510, M = N * N + 10;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int idx;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        ++idx;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] in = new int[n];
        Arrays.fill(he, -1);
        for (int[] r : richer) {
            int a = r[0], b = r[1];
            add(a, b);
            ++in[b];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if (in[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = he[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (quiet[ans[cur]] < quiet[ans[j]]) ans[j] = ans[cur];
                if (--in[j] == 0) queue.offer(j);
            }
        }
        return ans;
    }
}
