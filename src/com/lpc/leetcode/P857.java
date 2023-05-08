package com.lpc.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 雇佣K名工人的最低成本
 *
 * @author byu_rself
 * @date 2022/9/11 14:02
 */
public class P857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length, sum = 0;
        Integer[] index = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        // 等价于
        // Integer[] index = new Integer[n];
        // for (int i = 0; i < n; ++i) index[i] = i;

        // 定义 ri = wage[i] / quality[i]
        Arrays.sort(index, (a, b) -> wage[a] * quality[b] - wage[b] * quality[a]); // 按 r 升序
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a); // 大根堆
        for (int i = 0; i < k; ++i) {
            q.offer(quality[index[i]]);
            sum += quality[index[i]];
        }
        double ans = sum * ((double) wage[index[k - 1]] / quality[index[k - 1]]);
        for (int i = k; i < n; ++i) {
            int cur = quality[index[i]];
            if (cur < q.peek()) {
                sum -= q.poll() - cur;
                q.offer(cur);
                ans = Math.min(ans, sum * ((double) wage[index[i]] / cur));
            }
        }
        return ans;
    }
}
