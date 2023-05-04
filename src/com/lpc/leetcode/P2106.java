package com.lpc.leetcode;

/**
 * 摘水果
 *
 * @author byu_rself
 * @date 2023/5/4 21:00
 */
public class P2106 {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0, sum = 0;
        for (int i = 0, j = 0; j < fruits.length; ++j) {
            int pos = fruits[j][0], cnt = fruits[j][1];
            sum += cnt;
            while (i <= j && pos - fruits[i][0] + Math.min(Math.abs(startPos - fruits[i][0]), Math.abs(startPos - pos)) > k) {
                sum -= fruits[i++][1];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
