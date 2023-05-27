package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索II
 *
 * @author byu_rself
 * @date 2023/5/27 17:51
 */
public class P212 {

    char[][] board;
    int m, n;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited = new boolean[15][15];
    Set<String> set = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int index = board[i][j] - 'a';
                if (trie.next[index] != null) {
                    visited[i][j] = true;
                    dfs(i, j, trie.next[index]);
                    visited[i][j] = false;
                }
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(int x, int y, Trie node) {
        if (node.s != null) set.add(node.s);
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (visited[nx][ny]) continue;
            int index = board[nx][ny] - 'a';
            if (node.next[index] != null) {
                visited[nx][ny] = true;
                dfs(nx, ny, node.next[index]);
                visited[nx][ny] = false;
            }
        }
    }

    private static class Trie {
        Trie[] next;
        String s;

        public Trie() {
            next = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new Trie();
                }
                node = node.next[c - 'a'];
            }
            node.s = word;
        }
    }

    /*Set<String> set;
    List<String> ans = new ArrayList<>();
    char[][] board;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    boolean[][] visited = new boolean[15][15];

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        set = new HashSet<>(List.of(words));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                visited[i][j] = true;
                builder.append(board[i][j]);
                dfs(i, j, builder);
                visited[i][j] = false;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        return ans;
    }

    private void dfs(int x, int y, StringBuilder builder) {
        if (builder.length() > 10) return;
        String s = builder.toString();
        if (set.contains(s)) {
            ans.add(s);
            set.remove(s);
        }
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (visited[nx][ny]) continue;
            visited[nx][ny] = true;
            builder.append(board[nx][ny]);
            dfs(nx, ny, builder);
            visited[nx][ny] = false;
            builder.deleteCharAt(builder.length() - 1);
        }
    }*/
}
