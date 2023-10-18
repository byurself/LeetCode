package com.lpc.leetcode;

import java.util.PriorityQueue;

/**
 * 执行K次操作后的最大分数
 *
 * @author byu_rself
 * @date 2023/10/18 10:21
 */
public class P2530 {

    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            q.offer(num);
        }
        while (k-- > 0) {
            int x = q.poll();
            ans += x;
            q.offer((x + 2) / 3);
        }
        return ans;
    }
}
