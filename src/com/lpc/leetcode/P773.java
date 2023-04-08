package com.lpc.leetcode;

import java.util.*;

/**
 * 滑动谜题
 *
 * @author byu_rself
 * @date 2023/4/8 15:21
 */
public class P773 {

    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }
        String s = sb.toString();
        if ("123450".equals(s)) return 0;
        int step = 0;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++step;
            for (int i = 0; i < size; ++i) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!visited.contains(nextStatus)) {
                        if ("123450".equals(nextStatus)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        visited.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    private List<String> get(String status) {
        List<String> list = new ArrayList<>();
        char[] arr = status.toCharArray();
        int x = status.indexOf('0');
        for (int y : neighbors[x]) {
            swap(arr, x, y);
            list.add(new String(arr));
            swap(arr, x, y);
        }
        return list;
    }

    private void swap(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
