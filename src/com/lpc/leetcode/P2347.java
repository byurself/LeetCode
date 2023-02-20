package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 最好的扑克手牌
 *
 * @author byu_rself
 * @date 2023/2/20 10:31
 */
public class P2347 {

    @Test
    public void solution() {
        int[] ranks = new int[]{12, 12, 12, 9, 9};
        char[] suits = new char[]{'b', 'd', 'a', 'c', 'b'};
        System.out.println(bestHand(ranks, suits));
    }

    public String bestHand(int[] ranks, char[] suits) {
        Map<Integer, Integer> cntRanks = new HashMap<>();
        Map<Character, Integer> cntSuits = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            cntRanks.put(ranks[i], cntRanks.getOrDefault(ranks[i], 0) + 1);
            cntSuits.put(suits[i], cntSuits.getOrDefault(suits[i], 0) + 1);
        }
        if (cntSuits.size() == 1) return "Flush";
        boolean flag1 = false, flag2 = false;
        for (Integer key : cntRanks.keySet()) {
            if (cntRanks.get(key) >= 3) {
                flag1 = true;
            } else if (cntRanks.get(key) >= 2) {
                flag2 = true;
            }
        }
        if (flag1) return "Three of a Kind";
        else if (flag2) return "Pair";

        return "High Card";
    }
}
