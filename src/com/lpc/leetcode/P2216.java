package com.lpc.leetcode;

/**
 * 美化数组的最少删除数
 *
 * @author byu_rself
 * @date 2023/11/21 9:06
 */
public class P2216 {

    public int minDeletion(int[] nums) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if ((i - cnt) % 2 == 0 && i + 1 < n && nums[i] == nums[i + 1]) ++cnt;
        }
        return (n - cnt) % 2 == 0 ? cnt : cnt + 1;
    }
}
