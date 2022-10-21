package com.lpc.leetcode;

/**
 * 第K个语法符号
 *
 * @author byu_rself
 * @date 2022/10/20 0:39
 */
public class P779 {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }
}
