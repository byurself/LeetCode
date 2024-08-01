package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 心算挑战
 *
 * @author byu_rself
 * @date 2024/8/1 16:32
 */
public class LCP040 {

    @Test
    public void solution() {
        int[] cards = new int[]{1, 2, 8, 9};
        int cnt = 3;
        System.out.println(maxmiumScore(cards, cnt));
    }

    int[] cards;
    int cnt, n;

    public int maxmiumScore(int[] cards, int cnt) {
        this.cards = cards;
        this.cnt = cnt;
        Arrays.sort(cards);
        this.n = cards.length;
        int sum = 0;
        for (int i = n - cnt; i < n; ++i) {
            sum += cards[i];
        }
        if (sum % 2 == 0) return sum;

        int x = cards[n - cnt];
        int ans = replaceSum(sum, x);
        for (int i = n - cnt + 1; i < n; ++i) {
            if (cards[i] % 2 != x % 2) { // 找到一个最小的奇偶性和 x 不同的数
                ans = Math.max(ans, replaceSum(sum, cards[i]));
                break;
            }
        }
        return ans;
    }

    private int replaceSum(int sum, int x) {
        for (int i = n - cnt - 1; i >= 0; --i) {
            if (cards[i] % 2 != x % 2) { // 找到一个最大的奇偶性和 x 不同的数
                return sum - x + cards[i];
            }
        }
        return 0;
    }
}
