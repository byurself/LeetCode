package com.lpc.leetcode;

import java.util.*;

/**
 * 找出输掉零场或一场比赛的玩家
 *
 * @author byu_rself
 * @date 2024/5/22 9:44
 */
public class P2225 {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] m : matches) {
            int a = m[0], b = m[1];
            map.putIfAbsent(a, 0);
            map.merge(b, 1, Integer::sum);
        }
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            if (v == 0) a.add(k);
            else if (v == 1) b.add(k);
        }
        Collections.sort(a);
        Collections.sort(b);
        return List.of(a, b);
    }
}
