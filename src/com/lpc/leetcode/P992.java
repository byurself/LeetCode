package com.lpc.leetcode;

/**
 * K个不同整数的子数组
 *
 * @author byu_rself
 * @date 2023/11/2 10:35
 */
public class P992 {

    int n;
    int[] nums;

    public int subarraysWithKDistinct(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;
        int[] lower = new int[n], upper = new int[n];
        find(lower, k); // 找到距离当前位置i为右边界的满足k个不同字符的下标
        find(upper, k - 1); // 找到距离当前位置i为右边界的满足k - 1个不同字符的下标
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += upper[i] - lower[i];
        }
        return ans;
    }

    private void find(int[] arr, int k) {
        int[] cnt = new int[n + 1];
        for (int i = 0, j = 0, sum = 0; i < n; ++i) {
            int right = nums[i];
            if (cnt[right]++ == 0) ++sum;
            while (sum > k) {
                int left = nums[j++];
                if (--cnt[left] == 0) --sum;
            }
            arr[i] = j;
        }
    }
}
