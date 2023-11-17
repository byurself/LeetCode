package com.lpc.leetcode;

import java.util.*;

/**
 * 最大和查询
 *
 * @author byu_rself
 * @date 2023/11/17 9:21
 */
public class P2736 {

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = queries.length;
        int[][] index = new int[n][2];
        for (int i = 0; i < n; ++i) {
            index[i][0] = nums1[i];
            index[i][1] = nums2[i];
        }
        // 按 nums1 的值从大到小排序
        Arrays.sort(index, (a, b) -> b[0] - a[0]);
        Integer[] qid = new Integer[m];
        for (int i = 0; i < m; ++i) {
            qid[i] = i;
        }
        Arrays.sort(qid, (a, b) -> queries[b][0] - queries[a][0]);
        int[] ans = new int[m];
        List<int[]> stack = new ArrayList<>();
        int j = 0;
        for (int i : qid) {
            int x = queries[i][0], y = queries[i][1];
            while (j < n && index[j][0] >= x) {
                while (!stack.isEmpty() && stack.get(stack.size() - 1)[1] <= index[j][0] + index[j][1]) {
                    stack.remove(stack.size() - 1);
                }
                if (stack.isEmpty() || stack.get(stack.size() - 1)[0] < index[j][1]) {
                    stack.add(new int[]{index[j][1], index[j][0] + index[j][1]});
                }
                ++j;
            }
            Arrays.binarySearch()
            int p = lowerBound(stack, y);
            System.out.println(p);
            ans[i] = p < stack.size() ? stack.get(p)[1] : -1;
        }
        return ans;
    }

    // 开区间写法
    private int lowerBound(List<int[]> stack, int target) {
        int left = -1, right = stack.size();
        while (left + 1 < right) {
            int mid = left + right >>> 1;
            if (stack.get(mid)[0] >= target) right = mid;
            else left = mid;
        }
        return right;
    }
}
