package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 模拟行走机器人
 *
 * @author byu_rself
 * @date 2023/7/19 9:33
 */
public class P874 {

    static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> set = new HashSet<>(obstacles.length);
        for (int[] obstacle : obstacles) {
            set.add(getIndex(obstacle[0], obstacle[1]));
        }
        int ans = 0, k = 0, x = 0, y = 0;
        for (int command : commands) {
            if (command == -2) {
                // 左转
                k = (k + 3) % 4;
            } else if (command == -1) {
                // 右转
                k = (k + 1) % 4;
            } else {
                // 直行
                while (command-- > 0) {
                    int nx = x + dirs[k][0], ny = y + dirs[k][1];
                    if (set.contains(getIndex(nx, ny))) break;
                    x = nx;
                    y = ny;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }

    private int getIndex(int x, int y) {
        return x * 90000 + y;
    }
}
