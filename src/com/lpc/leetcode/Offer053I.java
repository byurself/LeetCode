package com.lpc.leetcode;

import org.junit.Test;

/**
 * 在排序数组中查找数字 I
 * @author byu_rself
 * @date 2022/8/11 10:41
 */
public class Offer053I {

    @Test
    public void solution() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(search2(nums, target));
    }

    /**
     * 二分
     */
    public int search(int[] nums, int target) {
        // 搜索target的右边界
        int length = nums.length;
        int l = 0, r = length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        // 数组中无target，直接退出
        if (r >= 0 && nums[r] != target) return 0;
        // 搜索target的左边界
        int right = l;
        l = 0;
        r = length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid - 1;
            else l = mid + 1;
        }
        int left = r;
        return right - left - 1;
    }

    /**
     * 二分，封装函数
     */
    public int search2(int[] nums, int target) {
        // 搜索target和target-1的右边界
        return binarySearch(nums, target) - binarySearch(nums, target - 1);
    }

    /**
     * 二分搜索target的右边界
     */
    private int binarySearch(int[] nums, int target) {
        int length = nums.length;
        int l = 0, r = length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public int search1(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) count++;
        }
        return count;
    }
}
