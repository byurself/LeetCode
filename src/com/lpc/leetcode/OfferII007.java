package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中和为0的三个数
 *
 * @author byu_rself
 * @date 2023/8/2 9:39
 */
public class OfferII007 {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 2; ++i) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int sum = nums[i] + nums[i + 1] + nums[i + 2];
            if (sum > 0) break;

            sum = nums[i] + nums[n - 2] + nums[n - 1];
            if (sum < 0) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(List.of(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j - 1]) ++j;
                    while (j < k && nums[k] == nums[k + 1]) --k;
                } else if (sum < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return ans;
    }
}
