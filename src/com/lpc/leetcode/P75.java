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
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                --p2;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                ++p0;
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
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            while (cnt-- > 0) {
                nums[index++] = key;
            }
        }
    }
}
