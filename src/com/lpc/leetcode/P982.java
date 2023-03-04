package com.lpc.leetcode;

/**
 * 按位与为零的三元组
 *
 * @author byu_rself
 * @date 2023/3/4 14:02
 */
public class P982 {

    public int countTriplets(int[] nums) {
        int ans = 0;
        int[] cnt = new int[1 << 16];
        for (int x : nums) {
            for (int y : nums) {
                cnt[x & y]++;
            }
        }
        for (int xy = 0; xy < (1 << 16); xy++) {
            for (int z : nums) {
                if ((xy & z) == 0) {
                    ans += cnt[xy];
                }
            }
        }
        return ans;
    }
}
