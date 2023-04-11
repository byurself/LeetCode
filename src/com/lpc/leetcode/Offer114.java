package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 外星文字典
 *
 * @author byu_rself
 * @date 2022/5/31 8:44
 */
public class Offer114 {

    @Test
    public void solution() {
        String[] words = new String[]{"mzgncrm", "ybm", "edullqwm", "zudnowuit", "xwmiidg", "zbgcizm", "uih", "adufdrgeq", "ipra", "jbzdbqrm", "xclagllk", "ira", "jixtztv", "scachvvftj", "kucchzuf", "mppwxs", "mxhqyh", "hayd", "ogckvemi"};
        System.out.println(alienOrder(words));
    }

    int N = 26, M = N * N, idx = 0, cnt = 0;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int[] in = new int[N], out = new int[N];
    boolean[] visited = new boolean[N];

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        ++out[a];
        ++in[b];
    }

    public String alienOrder(String[] words) {
        int n = words.length;
        Arrays.fill(he, -1);
        for (int i = 0; i < n; ++i) {
            for (char c : words[i].toCharArray()) {
                if (!visited[c - 'a']) {
                    visited[c - 'a'] = true;
                    ++cnt;
                }
            }
            for (int j = 0; j < i; ++j) {
                if (!build(words[j], words[i])) return "";
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 26; ++i) {
            if (visited[i] && in[i] == 0) queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append((char) (cur + 'a'));
            for (int i = he[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--in[j] == 0) queue.offer(j);
            }
        }
        return sb.length() == cnt ? sb.toString() : "";
    }

    private boolean build(String a, String b) {
        int m = a.length(), n = b.length();
        for (int i = 0; i < Math.min(m, n); i++) {
            int c1 = a.charAt(i) - 'a', c2 = b.charAt(i) - 'a';
            if (c1 != c2) {
                add(c1, c2);
                return true;
            }
        }
        return m <= n;
    }

/*    static final int VISITING = 1, VISITED = 2;
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
    }*/
}
