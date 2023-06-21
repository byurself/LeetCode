package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 黑白翻转棋
 *
 * @author byu_rself
 * @date 2023/6/21 15:22
 */
public class LCP041 {

    int m, n;
    String[] chessboard;

    public int flipChess(String[] chessboard) {
        m = chessboard.length;
        n = chessboard[0].length();
        this.chessboard = chessboard;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (chessboard[i].charAt(j) == '.') {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        return ans;
    }

    private int bfs(int i, int j) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        char[][] g = new char[m][];
        for (int k = 0; k < m; ++k) {
            g[k] = chessboard[k].toCharArray();
        }
        g[i][j] = 'X';
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            for (int a = -1; a <= 1; ++a) {
                for (int b = -1; b <= 1; ++b) {
                    if (a == 0 && b == 0) continue;
                    int x = i + a, y = j + b;
                    while (x >= 0 && x < m && y >= 0 && y < n && g[x][y] == 'O') {
                        x += a;
                        y += b;
                    }
                    if (x >= 0 && x < m && y >= 0 && y < n && g[x][y] == 'X') {
                        x -= a;
                        y -= b;
                        ans += Math.max(Math.abs(x - i), Math.abs(y - j));
                        while (x != i || y != j) {
                            g[x][y] = 'X';
                            queue.offer(new int[]{x, y});
                            x -= a;
                            y -= b;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
