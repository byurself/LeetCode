package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 合并相似的物品
 *
 * @author byu_rself
 * @date 2023/2/28 10:40
 */
public class P2363 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            int value = item[0], weight = item[1];
            map.put(value, map.getOrDefault(value, 0) + weight);
        }
        for (int[] item : items2) {
            int value = item[0], weight = item[1];
            map.put(value, map.getOrDefault(value, 0) + weight);
        }
        for (Integer value : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(value);
            list.add(map.get(value));
            ans.add(list);
        }
        ans.sort((a, b) -> a.get(0) - b.get(0));
        return ans;
    }
}
