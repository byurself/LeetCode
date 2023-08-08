package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 颜色分类
 *
 * @author byu_rself
 * @date 2022/10/11 11:19
 */
public class P75 {

    @Test
    public void solution() {
        int[] nums = new int[]{2, 0, 1};
        sortColors(nums);
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int c0 = 0, c2 = n - 1;
        for (int c1 = 0; c1 <= c2; ++c1) {
            while (c1 <= c2 && nums[c1] == 2) {
                swap(nums, c1, c2);
                --c2;
            }
            if (nums[c1] == 0) {
                swap(nums, c1, c0);
                ++c0;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public void sortColors1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.merge(num, 1, Integer::sum);
        int i = 0;
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            while (cnt-- > 0) {
                nums[i++] = key;
            }
        }
    }
}
