package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 数组中重复的数据
 *
 * @author byu_rself
 * @date 2022/5/8 8:34
 */
public class P442 {

    @Test
    public void solution() {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDuplicates(nums);
        list.forEach(System.out::println);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 将数nums[i]-1作为下标
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                // 给nums[i]加上「负号」表示数i+1已经出现过一次
                nums[index] = -nums[index];
            } else {
                list.add(index + 1);
            }
        }
        return list;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (set.contains(num)) {
                list.add(num);
                continue;
            }
            set.add(num);
        }
        return list;
    }
}
