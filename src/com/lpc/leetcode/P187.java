package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 重复的DNA序列
 *
 * @author byu_rself
 * @date 2023/5/14 11:33
 */
public class P187 {

    static int length = 10;
    Map<Character, Integer> map = new HashMap<>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n <= length) return ans;
        int x = 0;
        for (int i = 0; i < length - 1; ++i) {
            x = (x << 2) | map.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i + length <= n; ++i) {
            x = ((x << 2) | map.get(s.charAt(i + length - 1))) & ((1 << (length * 2)) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + length));
            }
        }
        return ans;
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 < n; ++i) {
            String cur = s.substring(i, i + 10);
            int cnt = map.getOrDefault(cur, 0);
            if (cnt == 1) ans.add(cur);
            map.put(cur, cnt + 1);
        }
        return ans;
    }
}
