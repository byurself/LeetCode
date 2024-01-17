package com.lpc.leetcode;

/**
 * 最大字符串配对数目
 *
 * @author byu_rself
 * @date 2024/1/17 9:29
 */
public class P2744 {

    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        boolean[][] visited = new boolean[26][26];
        for (String word : words) {
            int x = word.charAt(0) - 'a', y = word.charAt(1) - 'a';
            if (visited[y][x]) {
                ++ans;
            } else {
                visited[x][y] = true;
            }
        }
        return ans;
    }
}
