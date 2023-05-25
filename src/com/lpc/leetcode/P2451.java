package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 差值数组不同的字符串
 *
 * @author byu_rself
 * @date 2023/5/25 9:29
 */
public class P2451 {

    public String oddString(String[] words) {
        int n = words.length;
        int i = 1;
        for (; i < n; ++i) {
            if (!check(words[i], words[0])) {
                break;
            }
        }

        for (int j = 1; j < n; ++j) {
            if (j != i) {
                if (check(words[j], words[0])) {
                    return words[i];
                } else {
                    return words[0];
                }
            }
        }
        return "";
    }

    private boolean check(String s1, String s2) {
        int n = s1.length();
        int m = s1.charAt(0) - s2.charAt(0);
        for (int i = 1; i < n; i++) {
            if (s1.charAt(i) - s2.charAt(i) != m) {
                return false;
            }
        }
        return true;
    }

    public String oddString1(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        int n = words[0].length();
        for (String word : words) {
            var cs = new char[n - 1];
            for (int i = 0; i < n - 1; ++i) {
                cs[i] = (char) (word.charAt(i + 1) - word.charAt(i));
            }
            String s = String.valueOf(cs);
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(word);
        }
        for (List<String> list : map.values()) {
            if (list.size() == 1) return list.get(0);
        }
        return "";
    }
}
