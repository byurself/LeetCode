package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 咒语和药水的成功对数
 *
 * @author byu_rself
 * @date 2023/11/10 9:46
 */
public class P2300 {

    @Test
    public void solution() {
        int[] spells = new int[]{5, 1, 3};
        int[] potions = new int[]{1, 2, 3, 4, 5};
        long success = 7;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int left = 0, right = m - 1;
            while (left < right) {
                int mid = left + right >> 1;
                if ((long) spells[i] * potions[mid] >= success) right = mid;
                else left = mid + 1;
            }
            if ((long) spells[i] * potions[right] >= success) ans[i] = m - right;
        }
        return ans;
    }
}
