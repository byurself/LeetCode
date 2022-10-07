package com.lpc.leetcode;

/**
 * 寻找重复数
 *
 * @author byu_rself
 * @date 2022/10/7 15:30
 */
public class P287 {

    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
