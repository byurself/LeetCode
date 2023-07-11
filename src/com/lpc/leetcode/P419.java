package com.lpc.leetcode;

/**
 * 甲板上的战舰
 *
 * @author byu_rself
 * @date 2023/7/11 18:36
 */
public class P419 {

    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') continue;
                    if (j > 0 && board[i][j - 1] == 'X') continue;
                    ++ans;
                }
            }
        }
        return ans;
    }

    public int countBattleships1(char[][] board) {
        int m = board.length, n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    for (int k = j + 1; k < n && board[i][k] == 'X'; ++k) {
                        board[i][k] = '.';
                    }
                    for (int k = i + 1; k < m && board[k][j] == 'X'; ++k) {
                        board[k][j] = '.';
                    }
                    ++ans;
                }
            }
        }
        return ans;
    }
}
