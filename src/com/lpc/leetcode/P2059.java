package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 转化数字的最小运算数
 *
 * @author byu_rself
 * @date 2023/4/6 14:13
 */
public class P2059 {

    public int minimumOperations(int[] nums, int start, int goal) {
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.offer(start);
        map.put(start, 0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int step = map.get(cur);
            for (int num : nums) {
                int[] result = new int[]{cur + num, cur - num, cur ^ num};
                for (int x : result) {
                    if (x == goal) return step + 1;
                    if (x < 0 || x > 1000) continue;
                    if (map.containsKey(x)) continue;
                    map.put(x, step + 1);
                    queue.offer(x);
                }
            }
        }
        return -1;
    }
}
