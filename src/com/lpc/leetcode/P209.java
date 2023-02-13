package com.lpc.leetcode;

/**
 * 长度最小的子数组
 *
 * @author byu_rself
 * @date 2023/2/13 13:58
 */
public class P209 {

    /**
     * 滑动窗口
     */
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, n = nums.length;
        int sum = 0;
        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
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
                    ans = Math.min(j - i + 1, ans);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
