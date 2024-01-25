package com.lpc.leetcode;

import java.util.List;

/**
 * 计算K置位下标对应元素的和
 *
 * @author byu_rself
 * @date 2024/1/25 9:40
 */
public class P2859 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            // if (Integer.bitCount(i) == k) {
            if (bicCount(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    private int bicCount(int x) {
        int cnt = 0;
        while (x > 0) {
            x &= x - 1; // 把最低位的 1 置为 0
            ++cnt;
        }
        return cnt;
    }
}
