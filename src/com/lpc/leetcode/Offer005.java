package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 单词长度的最大乘积
 *
 * @author byu_rself
 * @date 2022/8/15 10:32
 */
public class Offer005 {

    @Test
    public void solution() {
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "fxyz", "abcdef"};
        System.out.println(maxProduct(words));
    }

    /**
     * 位运算
     */
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int t = 0, m = w.length();
            for (int i = 0; i < m; i++) {
                int u = w.charAt(i) - 'a';
                t |= (1 << u);
            }
            if (!map.containsKey(t) || map.get(t) < m) map.put(t, m);
        }
        int ans = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if ((a & b) == 0) ans = Math.max(ans, map.get(a) * map.get(b));
            }
        }
        return ans;
    }

    /**
     * 暴力
     */
    public int maxProduct1(String[] words) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            String p = words[i];
            for (int k = 0; k < p.length(); k++) {
                set.add(p.charAt(k));
            }

            for (int j = i + 1; j < words.length; j++) {
                boolean flag = true;
                String q = words[j];
                for (int k = 0; k < q.length(); k++) {
                    if (set.contains(q.charAt(k))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    max = Math.max(max, p.length() * q.length());
                }
            }
            set.clear();
        }
        return max;
    }
}
