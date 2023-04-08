package com.lpc.leetcode;

import java.util.*;

/**
 * 串联字符串的最大长度
 *
 * @author byu_rself
 * @date 2023/4/8 15:10
 */
public class P1239 {
    static Map<Integer, Integer> map = new HashMap<>();
    int n;
    int ans = Integer.MIN_VALUE;
    int[] hash;

    private int get(int cur) {
        if (map.containsKey(cur)) return map.get(cur);
        int ans = 0;
        for (int i = cur; i > 0; i -= lowbit(i)) ans++;
        map.put(cur, ans);
        return ans;
    }

    private int lowbit(int x) {
        return x & -x;
    }

    public int maxLength(List<String> arr) {
        n = arr.size();
        Set<Integer> set = new HashSet<>();
        for (String s : arr) {
            int val = 0;
            for (char c : s.toCharArray()) {
                int t = c - 'a';
                if (((val >> t) & 1) != 0) {
                    val = -1;
                    break;
                }
                val |= (1 << t);
            }
            if (val != -1) set.add(val);
        }
        n = set.size();
        if (n == 0) return 0;
        hash = new int[n];
        int idx = 0, total = 0;
        for (int i : set) {
            hash[idx++] = i;
            total |= i;
        }
        dfs(0, 0, total);
        return ans;
    }

    private void dfs(int u, int cur, int total) {
        if (get(cur | total) <= ans) return;
        if (u == n) {
            ans = Math.max(ans, get(cur));
            return;
        }
        // 选择该数字（如果可以）
        if ((hash[u] & cur) == 0) {
            dfs(u + 1, hash[u] | cur, total - (total & hash[u]));
        }
        // 不选择该数字
        dfs(u + 1, cur, total);
    }
}
