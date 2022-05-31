package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 *
 * @author byu_rself
 * @date 2022/5/31 8:44
 */
public class Offer114 {

    @Test
    public void solution() {
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienOrder(words));
    }

    static final int VISITING = 1, VISITED = 2;
    Map<Character, List<Character>> edges = new HashMap<Character, List<Character>>();
    Map<Character, Integer> states = new HashMap<Character, Integer>();
    boolean valid = true;
    char[] order;
    int index;

    public String alienOrder(String[] words) {
        int length = words.length;
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                edges.putIfAbsent(c, new ArrayList<Character>());
            }
        }
        for (int i = 1; i < length && valid; i++) {
            addEdge(words[i - 1], words[i]);
        }
        order = new char[edges.size()];
        index = edges.size() - 1;
        Set<Character> letterSet = edges.keySet();
        for (char u : letterSet) {
            if (!states.containsKey(u)) {
                dfs(u);
            }
        }
        if (!valid) {
            return "";
        }
        return new String(order);
    }

    public void addEdge(String before, String after) {
        int length1 = before.length(), length2 = after.length();
        int length = Math.min(length1, length2);
        int index = 0;
        while (index < length) {
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                break;
            }
            index++;
        }
        if (index == length && length1 > length2) {
            valid = false;
        }
    }

    public void dfs(char u) {
        states.put(u, VISITING);
        List<Character> adjacent = edges.get(u);
        for (char v : adjacent) {
            if (!states.containsKey(v)) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (states.get(v) == VISITING) {
                valid = false;
                return;
            }
        }
        states.put(u, VISITED);
        order[index] = u;
        index--;
    }
}
