package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 避免洪水泛滥
 *
 * @author byu_rself
 * @date 2023/10/13 9:32
 */
public class P1488 {

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        TreeSet<Integer> sunny = new TreeSet<>();
        Map<Integer, Integer> rainy = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int k = rains[i];
            if (k > 0) {
                if (rainy.containsKey(k)) {
                    Integer t = sunny.higher(rainy.get(k));
                    if (t == null) return new int[0];
                    ans[t] = k;
                    sunny.remove(t);
                }
                rainy.put(k, i);
            } else {
                sunny.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}
