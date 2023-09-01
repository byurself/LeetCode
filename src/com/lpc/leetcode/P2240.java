package com.lpc.leetcode;

/**
 * 买钢笔和铅笔的方案数
 *
 * @author byu_rself
 * @date 2023/9/1 9:13
 */
public class P2240 {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int x = 0; x <= total / cost1; ++x) {
            int y = (total - x * cost1) / cost2 + 1;
            ans += y;
        }
        return ans;
    }
}
