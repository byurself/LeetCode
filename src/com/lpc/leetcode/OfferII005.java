package com.lpc.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最大单词长度乘积
 *
 * @author byu_rself
 * @date 2023/8/3 14:08
 */
public class OfferII005 {

    public int maxProduct(String[] words) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0, m = word.length();
            for (int i = 0; i < m; ++i) {
                int u = word.charAt(i) - 'a';
                mask |= (1 << u);
            }
            if (!map.containsKey(mask) || map.get(mask) < m) map.put(mask, m);
        }
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if (((a & b) == 0)) {
                    ans = Math.max(ans, map.get(a) * map.get(b));
                }
            }
        }
        return ans;
    }

    public int maxProduct1(String[] words) {
        Set<Character> set = new HashSet<>();
        int ans = 0, n = words.length;
        for (int i = 0; i < n - 1; ++i) {
            String word1 = words[i];
            for (int k = 0; k < word1.length(); ++k) {
                set.add(word1.charAt(k));
            }

            for (int j = i + 1; j < n; ++j) {
                boolean flag = true;
                String word2 = words[j];
                for (int k = 0; k < word2.length(); ++k) {
                    if (set.contains(word2.charAt(k))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans = Math.max(ans, word1.length() * word2.length());
                }
            }
            set.clear();
        }
        return ans;
    }
}
