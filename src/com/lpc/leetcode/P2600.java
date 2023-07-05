package com.lpc.leetcode;

/**
 * K件物品的最大和
 *
 * @author byu_rself
 * @date 2023/7/5 9:03
 */
public class P2600 {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) return k;
        else if (numOnes + numZeros >= k) return numOnes;
        else return numOnes - (k - numOnes - numZeros);
    }
}
