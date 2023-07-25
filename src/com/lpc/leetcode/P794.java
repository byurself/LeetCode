package com.lpc.leetcode;

/**
 * 有效的井字游戏
 *
 * @author byu_rself
 * @date 2023/7/25 10:29
 */
public class P794 {

    public boolean validTicTacToe(String[] board) {
        StringBuilder all = new StringBuilder();
        int cntX = 0, cntO = 0;
        for (String b : board) {
            all.append(b);
            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                if (c == 'X') cntX++;
                else if (c == 'O') cntO++;
            }
        }
        if (cntX != cntO && cntX != cntO + 1) return false;
        if (win(all, 'X') && cntX != cntO + 1) return false;
        if (win(all, 'O') && cntX != cntO) return false;
        return true;
    }

    private boolean win(StringBuilder s, char c) {
        // 横向
        for (int i = 0; i < 9; i += 3) {
            if (s.charAt(i) == c && s.charAt(i + 1) == c && s.charAt(i + 2) == c) {
                return true;
            }
        }
        // 纵向
        for (int i = 0; i <= 2; ++i) {
            if (s.charAt(i) == c && s.charAt(i + 3) == c && s.charAt(i + 6) == c) {
                return true;
            }
        }
        // 斜向
        if (s.charAt(0) == c && s.charAt(4) == c && s.charAt(8) == c) {
            return true;
        }
        if (s.charAt(2) == c && s.charAt(4) == c && s.charAt(6) == c) {
            return true;
        }
        return false;
    }
}
