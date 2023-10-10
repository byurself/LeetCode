package com.lpc.leetcode;

/**
 * 搜索旋转排序数组II
 *
 * @author byu_rself
 * @date 2023/10/10 10:28
 */
public class P81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) return nums[0] == target;
        int left = 0, right = n - 1;
        // 忽略与 nums[0] 相同的元素，恢复二段性
        while (left < right && nums[0] == nums[right]) --right;
        int idx = right;
        // 从中间开始找，找到满足 >= nums[0] 的分割点（旋转点）
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] >= nums[0]) left = mid;
            else right = mid - 1;
        }
        // 通过和 nums[0] 比较，确定 target 是在旋转点的左边还是右边
        if (target >= nums[0]) {
            left = 0;
        } else {
            left = left + 1;
            right = idx;
        }
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return nums[right] == target;
    }
}
