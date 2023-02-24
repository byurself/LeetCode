package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 使数组中所有元素都等于零
 *
 * @author byu_rself
 * @date 2023/2/24 10:38
 */
public class P2357 {

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                int t = nums[i];
                for (int j = i; j < n; j++) {
                    nums[j] -= t;
                }
                ans++;
            }
        }
        return ans;
    }

    public int minimumOperations1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }

}
