package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author byu_rself
 * @date 2022/5/8 9:03
 */
public class P16 {

    @Test
    public void solution() {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}
