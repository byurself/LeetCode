package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 *
 * @author byu_rself
 * @date 2022/10/7 15:34
 */
public class P448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] == nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) ans.add(i + 1);
        }
        return ans;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int index = (num - 1) % n;
            nums[index] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
