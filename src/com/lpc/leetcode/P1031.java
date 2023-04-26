package com.lpc.leetcode;

/**
 * 两个非重叠子数组的最大和
 *
 * @author byu_rself
 * @date 2023/4/26 21:20
 */
public class P1031 {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) s[i + 1] = s[i] + nums[i];
        return Math.max(maxSubSum(s, firstLen, secondLen), maxSubSum(s, secondLen, firstLen));
    }

    private int maxSubSum(int[] s, int firstLen, int secondLen) {
        int maxSumA = 0, ans = 0;
        for (int i = firstLen + secondLen; i < s.length; ++i) {
            maxSumA = Math.max(maxSumA, s[i - secondLen] - s[i - firstLen - secondLen]);
            ans = Math.max(ans, maxSumA + s[i] - s[i - secondLen]);
        }
        return ans;
    }
}
