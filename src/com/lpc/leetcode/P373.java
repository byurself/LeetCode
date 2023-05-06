package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 查找和最小的K对数字
 *
 * @author byu_rself
 * @date 2023/5/6 21:03
 */
public class P373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < Math.min(nums1.length, k); ++i) {
            q.offer(new int[]{i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (k-- > 0 && !q.isEmpty()) {
            int[] idx = q.poll();
            ans.add(Arrays.asList(nums1[idx[0]], nums2[idx[1]]));
            if (++idx[1] < nums2.length) q.offer(idx);
        }
        return ans;
    }
}
