package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最大整除子集
 *
 * @author byu_rself
 * @date 2023/10/20 9:22
 */
public class P368 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 2, 4, 8};
        System.out.println(largestDivisibleSubset(nums));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n], g = new int[n];
        for (int i = 0; i < n; ++i) {
            int len = 1, prev = i;
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0) {
                    if (f[j] + 1 > len) {
                        len = f[j] + 1;
                        prev = j;
                    }
                }
            }
            f[i] = len;
            g[i] = prev;
        }
        /*for (int i = 0; i < n; ++i) {
            System.out.println("f[" + i + "] = " + f[i] + ", g[" + i + "] = " + g[i]);
        }*/
        int max = -1, idx = -1;
        for (int i = 0; i < n; ++i) {
            if (f[i] > max) {
                idx = i;
                max = f[i];
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (ans.size() < max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}
