package com.lpc.leetcode;

/**
 * 好子集的数目
 *
 * @author byu_rself
 * @date 2023/7/17 9:40
 */
public class P1994 {

    static int MOD = (int) 1e9 + 7;
    static int[] p = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29}; // 30以内的质数

    public int numberOfGoodSubsets(int[] nums) {
        int[] cnts = new int[35]; // 统计数字出现的次数
        for (int num : nums) ++cnts[num];
        int mask = 1 << 10;
        long[] f = new long[mask];
        f[0] = 1;
        for (int num = 2; num <= 30; ++num) {
            if (cnts[num] == 0) continue;
            // 对 num 进行试除, cur 的二进制位用来记录分解出现的质因数位置
            int cur = 0, x = num;
            boolean flag = true;
            for (int j = 0; j < 10 && flag; ++j) {
                int t = p[j], c = 0;
                while (x % t == 0) {
                    cur |= (1 << j);
                    x /= t;
                    ++c;
                }
                // 如果 num 能够被同一质数试除多次，说明 num 不能加到子集，跳过
                if (c > 1) flag = false;
            }
            if (!flag) continue;
            // 枚举前一状态 prev
            for (int prev = mask - 1; prev >= 0; prev--) {
                // 只有当前选择数与前一状态不冲突，则能够进行转移，将方案数进行累加
                if ((prev & cur) != 0) continue;
                f[prev | cur] = (f[prev | cur] + f[prev] * cnts[num]) % MOD;
            }
        }
        long ans = 0;
        // 统计所有非空集的方案数
        for (int i = 1; i < mask; ++i) ans = (ans + f[i]) % MOD;
        // 在此基础上，考虑每个 1 选择与否对答案的影响
        for (int i = 0; i < cnts[1]; ++i) ans = ans * 2 % MOD;
        return (int) ans;
    }
}
