package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 蓄水
 *
 * @author byu_rself
 * @date 2023/5/21 20:43
 */
public class LCP033 {

    @Test
    public void solution() {
        int[] bucket = new int[]{1, 3};
        int[] vat = new int[]{6, 8};
        System.out.println(storeWater(bucket, vat));
    }

    public int storeWater(int[] bucket, int[] vat) {
        int max = Arrays.stream(vat).max().getAsInt();
        if (max == 0) return 0;
        int n = vat.length, ans = Integer.MAX_VALUE;
        for (int i = 1; i <= max; ++i) { // 蓄水次数
            int j = 0; // 升级次数
            for (int k = 0; k < n; ++k) {
                j += Math.max(0, (vat[k] + i - 1) / i - bucket[k]);
            }
            ans = Math.min(ans, i + j);
        }
        return ans;
    }
}
