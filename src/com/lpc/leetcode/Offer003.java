package com.lpc.leetcode;

import org.junit.Test;

/**
 * 前 n 个数字二进制中 1 的个数
 *
 * @author byu_rself
 * @date 2022/8/15 11:03
 */
public class Offer003 {

    @Test
    public void solution() {
        int n = 85723;
        int[] bits = countBits(n);
        for (int bit : bits) {
            System.out.print(bit + "\t");
        }
    }

    /**
     * 位运算
     */
    // 从小到大遍历
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        // ans[i] = 「i >> 1 所包含的 1 的个数」+「i 的最低位是否为 1」
        for (int i = 1; i <= n; i++) ans[i] = ans[i >> 1] + (i & 1);
        return ans;
    }

    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0, mod = 0, num = i;
            while (num > 0) {
                mod = num % 2;
                if (mod == 1) count++;
                num /= 2;
            }
            ans[i] = count;
        }
        return ans;
    }
}
