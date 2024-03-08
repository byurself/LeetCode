package com.lpc.leetcode;

/**
 * 找出美丽数组的最小和
 *
 * @author byu_rself
 * @date 2024/3/8 9:59
 */
public class P2834 {
    private static final int MOD = (int) 1e9 + 7;

    /*
        对于[1, k - 1]内的数字:
        1 和 k - 1 只能选其中一个;
        2 和 k - 2 只能选其中一个;
        3 和 k - 3 只能选其中一个;
        ...
        一直到 k / 2，无论 k 是奇数还是偶数，它都可以选
    */
    public int minimumPossibleSum(int n, int k) {
        long m = k / 2;
        return n <= m ? (int) ((long) (1 + n) * n / 2 % MOD) :
                (int) ((m * (m + 1) + ((long) k + k + n - m - 1) * (n - m)) / 2 % MOD);
    }
}
