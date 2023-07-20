package com.lpc.leetcode;

/**
 * 查询后的偶数和
 *
 * @author byu_rself
 * @date 2023/7/20 10:42
 */
public class P985 {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int m = queries.length, sum = 0;
        int[] ans = new int[m];
        for (int num : nums) sum += num % 2 == 0 ? num : 0;
        for (int i = 0; i < m; ++i) {
            int val = queries[i][0], idx = queries[i][1];
            if (nums[idx] % 2 == 0) sum -= nums[idx];
            nums[idx] += val;
            if (nums[idx] % 2 == 0) sum += nums[idx];
            ans[i] = sum;
        }
        return ans;
    }
}
