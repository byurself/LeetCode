package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除字符使频率相同
 *
 * @author byu_rself
 * @date 2023/4/29 19:41
 */
public class P2423 {

    public boolean equalFrequency(String word) {
        int n = word.length();
        for (int i = 0; i < n; ++i) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < n; ++j) {
                if (j != i) {
                    map.merge(word.charAt(j), 1, Integer::sum);
                }
            }
            if (check(map)) return true;
        }
        return false;
    }

    /**
     * 检查剩余字符出现的次数是否相同
     */
    private boolean check(Map<Character, Integer> map) {
        int x = map.entrySet().iterator().next().getValue();
        for (int v : map.values()) {
            if (x != v) return false;
        }
        return true;
    }

}
