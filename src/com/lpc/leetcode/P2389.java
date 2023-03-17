package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 和有限的最长子序列
 *
 * @author byu_rself
 * @date 2023/3/17 12:54
 */
public class P2389 {

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = queries.length, m = nums.length;
        int[] ans = new int[n], sum = new int[m + 1];
        Arrays.sort(nums);
        for (int i = 1; i <= m; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; ++i) {
            int l = 0, r = m + 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (sum[mid] > queries[i]) r = mid;
                else l = mid + 1;
            }
            ans[i] = l - 1;
        }
        return ans;
    }
}
