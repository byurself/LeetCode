package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author byu_rself
 * @date 2022/5/7 11:32
 */
public class P15 {

    @Test
    public void solution() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> s : list) {
            System.out.println(s);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        // 对数组从小到大进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // 如果第i个数已经大于0了，则不可能找到三个数之和为0
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // 去重
                    while (left < right && nums[right] == nums[right - 1]) right--; // 去重
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
