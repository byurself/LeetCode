package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 最大为N的数字组合
 *
 * @author byu_rself
 * @date 2022/10/18 0:18
 */
public class P902 {

    String[] digits;
    char[] s;
    int[] dp;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = digits;
        s = Integer.toString(n).toCharArray();
        dp = new int[s.length];
        Arrays.fill(dp, -1);
        return f(0, true, false);
    }

    /**
     * @param i       构造第 i 位数字
     * @param isLimit 当前是否受到了 n 的约束
     * @param isNum   i 前面的数位是否填了数字
     * @return 结果
     */
    private int f(int i, boolean isLimit, boolean isNum) {
        // 如果填了数字，则为1种合法方案
        if (i == s.length) return isNum ? 1 : 0;
        // 在不受到任何约束的情况下，返回记录的结果，避免重复运算
        if (!isLimit && isNum && dp[i] >= 0) return dp[i];
        int ans = 0;
        // 前面不填数字，那么可以跳过当前数位，也不填数字
        if (!isNum) {
            // isLimit 改为 false，因为没有填数字，位数都比 n 要短，自然不会受到 n 的约束
            // isNum 仍然为 false，因为没有填任何数字
            ans = f(i + 1, false, false);
        }
        // 根据是否受到约束，决定可以填的数字的上限
        char up = isLimit ? s[i] : '9';
        for (String digit : digits) {
            // digit 超过上限，由于 digits 是有序的，后面的 digit 都会超过上限，故退出循环
            if (digit.charAt(0) > up) break;
            // isLimit：如果当前受到 n 的约束，且填的数字等于上限，那么后面仍然会受到 n 的约束
            // isNum 为 true，因为填了数字
            ans += f(i + 1, isLimit && digit.charAt(0) == up, true);
        }
        if (!isLimit && isNum) dp[i] = ans; // 在不受到任何约束的情况下，记录结果
        return ans;
    }
}
