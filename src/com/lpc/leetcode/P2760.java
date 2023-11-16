package com.lpc.leetcode;

/**
 * 最长奇偶子数组
 *
 * @author byu_rself
 * @date 2023/11/16 9:18
 */
public class P2760 {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length, ans = 0;
        for (int l = 0; l < n; ) {
            if (nums[l] % 2 == 0 && nums[l] <= threshold) {
                int r = l + 1;
                while (r < n && nums[r] % 2 != nums[r - 1] % 2 && nums[r] <= threshold) {
                    ++r;
                }
                ans = Math.max(ans, r - l);
                l = r;
            } else {
                ++l;
            }
        }
        return ans;
    }
}
