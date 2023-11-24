package com.lpc.leetcode;

import java.util.List;

/**
 * 统计和小于目标的下标对数目
 *
 * @author byu_rself
 * @date 2023/11/24 9:18
 */
public class P2824 {

    public int countPairs(List<Integer> nums, int target) {
        nums.sort((a, b) -> a - b);
        int ans = 0, n = nums.size();
        for (int j = 0; j < n; ++j) {
            int x = nums.get(j);
            int i = binarySearch(nums, target - x, j);
            ans += i;
        }
        return ans;
    }

    private int binarySearch(List<Integer> nums, int target, int right) {
        int left = 0;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    /*public int countPairs(List<Integer> nums, int target) {
        int ans = 0, n = nums.size();
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums.get(i) + nums.get(j) < target) {
                    ++ans;
                }
            }
        }
        return ans;
    }*/
}
