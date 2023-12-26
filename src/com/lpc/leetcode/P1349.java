package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 参加考试的最大学生数
 *
 * @author byu_rself
 * @date 2023/12/26 9:46
 */
public class P1349 {

    int[][] cache;

    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int[] a = new int[m]; // a[i] 是第 i 排可用椅子的下标集合
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (seats[i][j] == '.') {
                    a[i] |= 1 << j;
                }
            }
        }
        cache = new int[m][1 << n];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(m - 1, a[m - 1], a);
    }

    private int dfs(int i, int j, int[] a) {
        if (cache[i][j] != -1) return cache[i][j];
        if (i == 0) {
            if (j == 0) {
                return 0;
            }
            int lb = j & -j;
            return cache[i][j] = dfs(i, j & ~(lb * 3), a) + 1;
        }
        int ans = dfs(i - 1, a[i - 1], a); // 第 i 排空着
        for (int s = j; s > 0; s = (s - 1) & j) { // 枚举 j 的子集 s
            if ((s & (s >> 1)) == 0) { // s 没有连续的 1
                int t = a[i - 1] & ~(s << 1 | s >> 1); // 去掉不能坐人的位置
                ans = Math.max(ans, dfs(i - 1, t, a) + Integer.bitCount(s));
            }
        }
        return cache[i][j] = ans;
    }
}
