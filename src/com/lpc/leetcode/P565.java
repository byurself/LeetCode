package com.lpc.leetcode;

/**
 * 数组嵌套
 *
 * @author byu_rself
 * @date 2023/7/12 9:51
 */
public class P565 {

    public int arrayNesting(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            int cur = i, cnt = 0;
            while (nums[cur] != -1) {
                ++cnt;
                int t = cur;
                cur = nums[cur];
                nums[t] = -1;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
