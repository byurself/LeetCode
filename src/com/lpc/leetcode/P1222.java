package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以攻击国王的皇后
 *
 * @author byu_rself
 * @date 2023/7/19 10:14
 */
public class P1222 {

    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        int x = king[0], y = king[1];
        boolean[][] isQueue = new boolean[8][8];
        for (int[] q : queens) {
            isQueue[q[0]][q[1]] = true;
        }
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            while (0 <= nx && nx < 8 && 0 <= ny && ny < 8) {
                if (isQueue[nx][ny]) {
                    ans.add(List.of(nx, ny));
                    break;
                }
                nx += d[0];
                ny += d[1];
            }
        }
        return ans;
    }

    /*static int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int x = king[0], y = king[1];
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] visited = new boolean[8][8];
        for (int[] queen : queens) {
            visited[queen[0]][queen[1]] = true;
        }
        boolean[] checked = new boolean[8]; // 8个方向
        for (int step = 1; step <= 8; ++step) {
            for (int i = 0; i < 8; ++i) {
                if (checked[i]) continue;
                int nx = x + dirs[i][0] * step, ny = y + dirs[i][1] * step;
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                    if (!visited[nx][ny]) continue;
                    ans.add(List.of(nx, ny));
                }
                checked[i] = true;
            }
        }
        return ans;
    }*/
}
