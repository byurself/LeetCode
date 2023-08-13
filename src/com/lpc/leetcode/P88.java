package com.lpc.leetcode;

import org.junit.Test;

/**
 * 合并两个有序数组
 *
 * @author byu_rself
 * @date 2022/5/25 19:36
 */
public class P88 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.println(num);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; j >= 0; --k) {
            nums1[k] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        for (int index = 0, i = 0, j = 0; index < m + n; ++index) {
            if (i < m && j < n) {
                ans[index] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
            } else if (i < m) {
                ans[index] = nums1[i++];
            } else if (j < n) {
                ans[index] = nums2[j++];
            }
        }
        if (m + n >= 0) System.arraycopy(ans, 0, nums1, 0, m + n);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
