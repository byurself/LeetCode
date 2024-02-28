package com.lpc.leetcode;

/**
 * 使二叉树所有路径值相等的最小代价
 *
 * @author byu_rself
 * @date 2024/2/28 9:41
 */
public class P2673 {

    // 根节点到每个叶子节点的路径值相等，实际上等价于以任意节点为根节点的子树到该子树的每个叶子节点的路径值相等。
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n / 2; i > 0; --i) {
            ans += Math.abs(cost[2 * i - 1] - cost[2 * i]); // 使两个子节点的值变成一样
            cost[i - 1] += Math.max(cost[2 * i - 1], cost[2 * i]); // 累加路径和
        }
        return ans;
    }
}
