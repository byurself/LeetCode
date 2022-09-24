package com.lpc.leetcode;

import org.junit.Test;

/**
 * 拆炸弹
 *
 * @author byu_rself
 * @date 2022/9/24 17:47
 */
public class P1652 {

    @Test
    public void solution() {
        int[] code = new int[]{5, 7, 1, 4};
        int k = 3;
        int[] decrypt = decrypt(code, k);
        for (int m : decrypt) {
            System.out.print(m + " ");
        }
    }

    /**
     * 前缀和
     */
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) return ans;

        int[] sum = new int[n * 2 + 10];
        for (int i = 1; i <= 2 * n; i++) sum[i] += sum[i - 1] + code[(i - 1) % n];
        for (int i = 1; i <= n; i++) {
            if (k < 0) ans[i - 1] = sum[i + n - 1] - sum[i + n + k - 1];
            else ans[i - 1] = sum[i + k] - sum[i];
        }
        return ans;
    }

    public int[] decrypt1(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) return ans;

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                for (int j = i + 1; j < i + k + 1; j++) {
                    ans[i] += code[j % n];
                }
            } else {
                for (int j = i + k; j < i; j++) {
                    ans[i] += code[(j + n) % n];
                }
            }
        }
        return ans;
    }
}
