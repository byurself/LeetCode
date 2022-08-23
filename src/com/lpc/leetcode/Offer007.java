package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中和为 0 的三个数
 *
 * @author byu_rself
 * @date 2022/8/23 10:22
 */
public class Offer007 {

    @Test
    public void solution() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer n : list) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                // 去重
                while (j > i + 1 && j < n && nums[j] == nums[j - 1]) j++;
                if (j >= k) break;
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}
