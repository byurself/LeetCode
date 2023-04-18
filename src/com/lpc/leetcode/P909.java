package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 蛇梯棋
 *
 * @author byu_rself
 * @date 2023/4/18 8:58
 */
public class P909 {

    int n;
    int[] nums;

    public int snakesAndLadders(int[][] board) {
        if (board[0][0] != -1) return -1;
        n = board.length;
        nums = new int[n * n + 1];
        boolean flag = true;
        for (int i = n - 1, index = 1; i >= 0; --i) {
            for (int j = flag ? 0 : n - 1; flag ? j < n : j >= 0; j += flag ? 1 : -1) {
                nums[index++] = board[i][j];
            }
            flag = !flag;
        }
        return bfs();
    }

    private int bfs() {
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.offer(1);
        map.put(1, 0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int step = map.get(cur);
            if (cur == n * n) return step;
            for (int i = 1; i <= 6; ++i) {
                int ni = cur + i;
                if (ni <= 0 || ni > n * n) continue;
                if (nums[ni] != -1) ni = nums[ni];
                if (map.containsKey(ni)) continue;
                map.put(ni, step + 1);
                queue.offer(ni);
            }
        }
        return -1;
    }
}
