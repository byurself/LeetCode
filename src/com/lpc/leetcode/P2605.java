package com.lpc.leetcode;

/**
 * 从两个数字数组里生成最小数字
 *
 * @author byu_rself
 * @date 2023/9/5 10:11
 */
public class P2605 {

    public int minNumber(int[] nums1, int[] nums2) {
        boolean[] s1 = new boolean[10], s2 = new boolean[10];
        for (int x : nums1) s1[x] = true;
        for (int x : nums2) s2[x] = true;
        int a = 0, b = 0;
        for (int i = 1; i < 10; ++i) {
            if (s1[i] & s2[i]) return i;
            if (a == 0 && s1[i]) a = i;
            if (b == 0 && s2[i]) b = i;
        }
        return Math.min(a * 10 + b, b * 10 + a);
    }
}
