package com.lpc.leetcode;

/**
 * 得分最高的单词集合
 *
 * @author byu_rself
 * @date 2023/2/26 14:02
 */
public class P1255 {

    private String[] words;
    private int[] score = new int[26], left = new int[26];
    private int ans;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        for (char c : letters) left[c - 'a']++;
        dfs(words.length - 1, 0);
        return ans;
    }

    private void dfs(int i, int total) {
        if (i < 0) {
            ans = Math.max(ans, total);
            return;
        }

        // 不选 words[i]
        dfs(i - 1, total);

        // 选 words[i]
        char[] s = words[i].toCharArray();
        boolean flag = true;
        for (char c : s) {
            if (left[c - 'a']-- == 0) {
                flag = false; // 剩余字母不足
            }
            total += score[c - 'a'];
        }

        if (flag) dfs(i - 1, total);

        for (char c : s) ++left[c - 'a'];
    }
}
