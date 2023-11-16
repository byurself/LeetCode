package com.lpc.leetcode;

/**
 * 解数独
 *
 * @author byu_rself
 * @date 2023/11/16 9:39
 */
public class P37 {

    // 表示 行、列、3*3 的方格的数字是否被使用过
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][][] box = new boolean[3][3][10];
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int x = board[i][j] - '0';
                    row[i][x] = true;
                    col[j][x] = true;
                    box[i / 3][j / 3][x] = true;
                }
            }
        }
        dfs(0, 0);
    }

    // 按行填充
    private boolean dfs(int x, int y) {
        if (y == 9) return dfs(x + 1, 0);
        if (x == 9) return true;
        // 当前位置非空，尝试填充下一个数字
        if (board[x][y] != '.') return dfs(x, y + 1);
        for (int i = 1; i <= 9; ++i) {
            // 数字 i 未被使用过
            if (!row[x][i] && !col[y][i] && !box[x / 3][y / 3][i]) {
                board[x][y] = (char) (i + '0');
                row[x][i] = col[y][i] = box[x / 3][y / 3][i] = true;
                if (dfs(x, y + 1)) {
                    break;
                } else {
                    board[x][y] = '.';
                    row[x][i] = col[y][i] = box[x / 3][y / 3][i] = false;
                }
            }
        }
        return board[x][y] != '.';
    }
}
