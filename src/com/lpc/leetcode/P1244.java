package com.lpc.leetcode;

/**
 * 最大相等频率
 *
 * @author byu_rself
 * @date 2023/7/8 18:05
 */
public class P1244 {

    static int[] cnt = new int[100010], sum = new int[100010];

    public int maxEqualFreq(int[] nums) {
        int n = nums.length, max = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = nums[i], cur = ++cnt[x], len = i + 1;
            sum[cur]++;
            sum[cur - 1]--;
            max = Math.max(max, cur);
            if (max == 1) ans = len;
            if (max * sum[max] + 1 == len) ans = len;
            if ((max - 1) * (sum[max - 1] + 1) + 1 == len) ans = len;
        }
        return ans;
    }
}
