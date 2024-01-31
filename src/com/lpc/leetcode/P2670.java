package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出不同元素数目差数组
 *
 * @author byu_rself
 * @date 2024/1/31 9:40
 */
public class P2670 {

    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int[] ans = new int[n], suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            set.add(nums[i]);
            suffix[i] = set.size();
        }
        set.clear();
        for (int i = 0; i < n; ++i) {
            set.add(nums[i]);
            ans[i] = set.size() - suffix[i + 1];
        }
        return ans;
    }

    public int[] distinctDifferenceArray1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    ans[i]++;
                }
            }
            set.clear();
            for (int j = n - 1; j > i; --j) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    ans[i]--;
                }
            }
            set.clear();
        }
        return ans;
    }
}
