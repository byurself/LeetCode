package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计出现过一次的公共字符串
 *
 * @author byu_rself
 * @date 2024/1/12 9:37
 */
public class P2085 {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (String s : words1) map1.merge(s, 1, Integer::sum);
        for (String s : words2) map2.merge(s, 1, Integer::sum);
        int ans = 0;
        for (Map.Entry<String, Integer> e : map1.entrySet()) {
            if (e.getValue() == 1 && map2.getOrDefault(e.getKey(), 0) == 1) {
                ++ans;
            }
        }
        return ans;
    }
}
