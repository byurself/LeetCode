package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中不等三元组的数目
 *
 * @author byu_rself
 * @date 2023/6/13 9:56
 */
public class P2475 {

    public int unequalTriplets(int[] nums) {
        int n = nums.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int a = 0;
        for (int b : map.values()) {
            int c = n - a - b;
            ans += a * b * c;
            a += b;
        }
        return ans;
    }

    public int unequalTriplets2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && nums[j] == nums[i]) ++j;
            ans += i * (j - i) * (n - j);
        }
        return ans;
    }

    public int unequalTriplets1(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) ++ans;
                }
            }
        }
        return ans;
    }
}
