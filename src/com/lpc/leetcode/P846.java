package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 一手顺子
 *
 * @author byu_rself
 * @date 2022/9/1 10:35
 */
public class P846 {

    @Test
    public void solution() {
        int[] hand = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            Integer n = queue.poll();
            if (map.get(n) == 0) continue;
            for (int i = 0; i < groupSize; i++) {
                Integer cnt = map.getOrDefault(n + i, 0);
                if (cnt == 0) return false;
                map.put(n + i, cnt - 1);
            }
        }

        return true;
    }
}
