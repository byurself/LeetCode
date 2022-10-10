package com.lpc.leetcode;

/**
 * 使序列递增的最小交换次数
 *
 * @author byu_rself
 * @date 2022/10/10 14:45
 */
public class P801 {

    public int minSwap(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < length; i++) {
            int a1 = nums1[i - 1], a2 = nums1[i], b1 = nums2[i - 1], b2 = nums2[i];
            if ((a1 < a2 && b1 < b2) && (b1 < a2 && a1 < b2)) {
                // 如果i[不互换]，则i-1可[互换]也可[不互换]
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                // 如果i[互换]，则i-1可[互换]也可[不互换]
                dp[i][1] = dp[i][0] + 1;
            } else if (a1 < a2 && b1 < b2) {
                // 如果i[不互换]，则i-1必须[不互换]
                dp[i][0] = dp[i - 1][0];
                // 如果i[互换]，则i-1必须[互换]
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                // 如果i[不互换]，则i-1必须[互换]
                dp[i][0] = dp[i - 1][1];
                // 如果i[互换]，则i-1必须[不互换]
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[length - 1][0], dp[length - 1][1]);
    }
}
