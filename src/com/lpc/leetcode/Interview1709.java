package com.lpc.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 第 k 个数
 *
 * @author byu_rself
 * @date 2022/9/28 10:07
 */
public class Interview1709 {

    private static int[] nums = new int[]{3, 5, 7};

    public int getKthMagicNumber(int k) {
        int[] ans = new int[k + 1];
        ans[1] = 1;
        for (int num3 = 1, num5 = 1, num7 = 1, i = 2; i <= k; i++) {
            int a = ans[num3] * 3, b = ans[num5] * 5, c = ans[num7] * 7;
            int min = Math.min(a, Math.min(b, c));
            if (min == a) num3++;
            if (min == b) num5++;
            if (min == c) num7++;
            ans[i] = min;
        }
        return ans[k];
    }

    public int getKthMagicNumber1(int k) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> q = new PriorityQueue<>();
        set.add(1L);
        q.offer(1L);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            long n = q.poll();
            ans = (int) n;
            for (int num : nums) {
                long cur = n * num;
                if (!set.contains(cur)) {
                    set.add(cur);
                    q.offer(cur);
                }
            }
        }
        return ans;
    }
}
