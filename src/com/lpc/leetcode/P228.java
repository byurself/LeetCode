package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 *
 * @author byu_rself
 * @date 2023/8/26 15:44
 */
public class P228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0, j; i < n; i = j + 1) {
            j = i;
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) ++j;
            ans.add(i == j ? String.valueOf(nums[i]) : String.format("%d->%d", nums[i], nums[j]));
        }
        return ans;
    }
}
