package com.lpc.leetcode;

/**
 * 不同的二叉搜索树
 *
 * @author byu_rself
 * @date 2023/9/12 10:10
 */
public class P96 {

    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                f[i] += f[j - 1] * f[i - j];
            }
        }
        return f[n];
    }
}
