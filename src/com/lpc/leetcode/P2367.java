package com.lpc.leetcode;

/**
 * 算术三元组的数目
 *
 * @author byu_rself
 * @date 2023/3/31 14:32
 */
public class P2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        boolean[] visited = new boolean[301];
        for (int num : nums) {
            visited[num] = true;
        }
        for (int num : nums) {
            if (visited[num + diff] && visited[num + 2 * diff]) ++ans;
        }
        return ans;
    }

    public int arithmeticTriplets1(int[] nums, int diff) {
        int n = nums.length, ans = 0;
        for (int j = 1; j < n - 1; ++j) {
            for (int i = 0; i < j; ++i) {
                for (int k = j + 1; k < n; ++k) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) ++ans;
                }
            }
        }
        return ans;
    }
}
