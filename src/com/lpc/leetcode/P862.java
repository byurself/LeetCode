package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 和至少为 K 的最短子数组
 *
 * @author byu_rself
 * @date 2022/10/26 15:58
 */
public class P862 {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] s = new long[n + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int ans = n + 1;
        for (int i = 0; i < n; i++) s[i + 1] = s[i] + nums[i];
        for (int i = 0; i <= n; i++) {
            long cur = s[i];
            while (!q.isEmpty() && cur - s[q.peekFirst()] >= k) {
                ans = Math.min(ans, i - q.pollFirst());
            }
            while (!q.isEmpty() && s[q.peekLast()] >= cur) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return ans > n ? -1 : ans;
    }
}
