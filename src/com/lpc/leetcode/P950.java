package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 按递增顺序显示卡牌
 *
 * @author byu_rself
 * @date 2023/7/20 10:31
 */
public class P950 {

    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) queue.offer(i);
        int[] ans = new int[n];
        Arrays.sort(deck);
        for (int x : deck) {
            ans[queue.poll()] = x;
            if (!queue.isEmpty()) queue.offer(queue.poll());
        }
        return ans;
    }
}
