package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 根据字符出现频率排序
 *
 * @author byu_rself
 * @date 2022/9/1 10:18
 */
public class P451 {

    @Test
    public void solution() {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder builder = new StringBuilder();
        for (Character c : list) {
            builder.append(String.valueOf(c).repeat(map.get(c)));
        }

        return builder.toString();
    }
}
