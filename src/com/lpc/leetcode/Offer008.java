package com.lpc.leetcode;

import org.junit.Test;

/**
 * 和大于等于 target 的最短子数组
 *
 * @author byu_rself
 * @date 2022/8/23 10:41
 */
public class Offer008 {

    @Test
    public void solution() {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * 前缀和+二分
     */
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] sum = new int[length + 1];
        int ans = length + 1;
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= length; i++) {
            int d = sum[i] - target;
            int l = 0, r = i;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (sum[mid] <= d) l = mid;
                else r = mid - 1;
            }
            if (sum[l] <= d) ans = Math.min(ans, i - l);
        }
        return ans == length + 1 ? 0: ans;
    }

    /**
     * 暴力
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans;
    }
}
