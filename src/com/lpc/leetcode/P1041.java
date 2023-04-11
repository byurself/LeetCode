package com.lpc.leetcode;

/**
 * 困于环中的机器人
 *
 * @author byu_rself
 * @date 2023/4/11 11:12
 */
public class P1041 {
    public boolean isRobotBounded(String instructions) {
        int[] dist = new int[4];
        int k = 0;
        for (int i = 0; i < instructions.length(); ++i) {
            char c = instructions.charAt(i);
            if (c == 'L') k = (k + 1) % 4;
            else if (c == 'R') k = (k + 3) % 4;
            else ++dist[k];
        }
        return (k != 0) || (dist[0] == dist[2] && dist[1] == dist[3]);
    }
}
