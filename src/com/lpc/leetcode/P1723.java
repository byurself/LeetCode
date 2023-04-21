package com.lpc.leetcode;

/**
 * 完成所有工作的最短时间
 *
 * @author byu_rself
 * @date 2023/4/21 16:07
 */
public class P1723 {

    int[] jobs;
    int n, k;
    int[] sum;
    int ans = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        this.jobs = jobs;
        this.k = k;
        this.n = jobs.length;
        sum = new int[n];
        dfs(0, 0, 0);
        return ans;
    }

    /**
     * @param cur  当前处理到的工作
     * @param used 当前分配给了多少个工人
     * @param max  当前的最大工作时间
     */
    private void dfs(int cur, int used, int max) {
        if (max >= ans) return;
        if (cur == n) {
            ans = max;
            return;
        }
        // 优先分配给空闲工人
        if (used < k) {
            sum[used] = jobs[cur];
            dfs(cur + 1, used + 1, Math.max(max, sum[used]));
            sum[used] = 0;
        }
        for (int i = 0; i < used; ++i) {
            sum[i] += jobs[cur];
            dfs(cur + 1, used, Math.max(max, sum[i]));
            sum[i] -= jobs[cur];
        }
    }
}
