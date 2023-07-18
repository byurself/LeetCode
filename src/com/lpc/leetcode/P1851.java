package com.lpc.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 包含每个查询的最小区间
 *
 * @author byu_rself
 * @date 2023/7/18 9:28
 */
public class P1851 {

    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length;
        // 区间按照左端点从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] qs = new int[m][2];
        for (int i = 0; i < m; ++i) {
            qs[i] = new int[]{queries[i], i};
        }
        // 查询按照从小到大排序
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        // 按区间长度从小到大排序的优先队列 (区间长度, 右端点)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        for (int[] q : qs) {
            // 区间的左端点小于当前查询的左端点，加入堆中
            while (i < n && intervals[i][0] <= q[0]) {
                int a = intervals[i][0], b = intervals[i][1];
                pq.offer(new int[]{b - a + 1, b});
                ++i;
            }
            // 堆顶区间的右端点小于当前查询的左端点，弹出
            while (!pq.isEmpty() && pq.peek()[1] < q[0]) {
                pq.poll();
            }
            // 如果优先队列不为空，那么堆顶元素就是包含 queries[i] 的最小区间
            if (!pq.isEmpty()) {
                ans[q[1]] = pq.peek()[0];
            }
        }
        return ans;
    }
}
