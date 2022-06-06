package com.lpc.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * My Calendar III
 *
 * @author byu_rself
 * @date 2022/6/6 9:32
 */
public class P732 {
    private TreeMap<Integer, Integer> cnt;

    public P732() {
        cnt = new TreeMap<Integer, Integer>();
    }

    public int book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
        }
        return ans;
    }
}
