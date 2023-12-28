package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 通过最少操作次数使数组的和相等
 *
 * @author byu_rself
 * @date 2023/2/27 13:39
 */
public class P1775 {

    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (6 * m < n || 6 * n < m) return -1;
        // int d = Arrays.stream(nums2).sum() - Arrays.stream(nums1).sum();
        int d = 0;
        for (int x : nums2) d += x;
        for (int x : nums1) d -= x;
        // 交换，同意让 nums1 的数变大，nums2 的数变小
        if (d < 0) {
            d = -d;
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int[] cnt = new int[6];
        for (int x : nums1) ++cnt[6 - x];
        for (int x : nums2) ++cnt[x - 1];
        int ans = 0;
        for (int i = 5; i > 0; --i) {
            while (cnt[i] > 0 && d > 0) {
                d -= i;
                --cnt[i];
                ++ans;
            }
        }
        return d <= 0 ? ans : -1;
    }
}
