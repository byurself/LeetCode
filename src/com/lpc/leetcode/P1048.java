package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长字符串链
 *
 * @author byu_rself
 * @date 2023/4/27 20:21
 */
public class P1048 {

    public int longestStrChain(String[] words) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            int res = 0;
            for (int i = 0; i < word.length(); ++i) {
                String t = word.substring(0, i) + word.substring(i + 1);
                res = Math.max(res, map.getOrDefault(t, 0));
            }
            map.put(word, res + 1);
            ans = Math.max(ans, res + 1);
        }
        return ans;
    }

    /*Map<String, Integer> map = new HashMap<>();

    public int longestStrChain(String[] words) {
        for (String word : words) map.put(word, 0);
        int ans = 0;
        for (String s : map.keySet()) {
            ans = Math.max(ans, dfs(s));
        }
        return ans;
    }

    private int dfs(String s) {
        int ans = map.get(s);
        if (ans > 0) return ans;
        for (int i = 0; i < s.length(); ++i) {
            String t = s.substring(0, i) + s.substring(i + 1);
            if (map.containsKey(t)) ans = Math.max(ans, dfs(t));
        }
        map.put(s, ans + 1);
        return ans + 1;
    }*/
}
