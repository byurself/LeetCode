package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 查找和替换模式
 *
 * @author byu_rself
 * @date 2022/6/12 15:36
 */
public class P890 {

    @Test
    public void solution() {
        String[] words = new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> list = findAndReplacePattern(words, pattern);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern) && match(pattern, word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    public boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i), y = pattern.charAt(i);
            if (!map.containsKey(x)) {
                map.put(x, y);
            } else if (map.get(x) != y) { // word 中的同一字母必须映射到 pattern 中的同一字母上
                return false;
            }
        }
        return true;
    }
}
