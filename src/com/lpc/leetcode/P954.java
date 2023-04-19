package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二倍数对数组
 *
 * @author byu_rself
 * @date 2023/4/19 15:33
 */
public class P954 {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) map.merge(n, 1, Integer::sum);
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> a - b);
        for (int key : list) {
            int cnt = map.get(key);
            if (key > 0) {
                if (map.getOrDefault(2 * key, 0) < cnt) return false;
                if (cnt > 0) map.put(2 * key, map.get(2 * key) - cnt);
            } else if (key == 0) { // 对 0 特殊处理
                if (map.get(key) % 2 != 0) return false;
            } else {
                if (cnt > 0) {
                    if ((key % 2 != 0 || map.getOrDefault(key / 2, 0) < cnt)) return false;
                    map.put(key / 2, map.get(key / 2) - cnt);
                }
            }
        }
        return true;
    }
}
