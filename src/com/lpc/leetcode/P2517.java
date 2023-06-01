package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 礼盒的最大甜蜜度
 *
 * @author byu_rself
 * @date 2023/6/1 10:39
 */
public class P2517 {

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int l = 0, r = price[price.length - 1] - price[0];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(price, k, mid)) l = mid;
            else r = mid - 1;

        }
        return l;
    }

    private boolean check(int[] price, int k, int x) {
        int cnt = 0, pre = -x;
        for (int cur : price) {
            if (cur - pre >= x) {
                pre = cur;
                ++cnt;
            }
        }
        return cnt >= k;
    }
}
