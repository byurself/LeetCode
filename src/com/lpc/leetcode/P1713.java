package com.lpc.leetcode;

import java.util.*;

/**
 * 得到子序列的最少操作次数
 *
 * @author byu_rself
 * @date 2023/2/19 10:47
 */
public class P1713 {

    public int minOperations(int[] target, int[] arr) {
        int n = target.length, m = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(target[i], i);
        List<Integer> list = new ArrayList<>();
        for (int a : arr) if (map.containsKey(a)) list.add(map.get(a));
        int length = list.size(), max = 0;
        int[] f = new int[length + 1], g = new int[length + 1];
        Arrays.fill(g, Integer.MAX_VALUE);
        for (int i = 0; i < length; i++) {
            int index = list.get(i);
            int l = 0, r = length;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (g[mid] < index) l = mid;
                else r = mid - 1;
            }
            int t = r + 1;
            f[i] = t;
            g[t] = Math.min(g[t], index);
            max = Math.max(max, f[i]);
        }
        return n - max;
    }
}
