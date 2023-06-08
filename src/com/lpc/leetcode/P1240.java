package com.lpc.leetcode;

/**
 * 铺瓷砖
 *
 * @author byu_rself
 * @date 2023/6/8 9:39
 */
public class P1240 {

    int ans, n, m;
    boolean[][] rect;

    public int tilingRectangle(int n, int m) {
        ans = Math.max(n, m);
        rect = new boolean[n][m];
        this.n = n;
        this.m = m;
        dfs(0, 0, 0);
        return ans;
    }

    public void dfs(int x, int y, int cnt) {
        if (cnt >= ans) return;
        if (x >= n) {
            ans = cnt;
            return;
        }
        // 检测下一行
        if (y >= m) {
            dfs(x + 1, 0, cnt);
            return;
        }
        // 如当前已经被覆盖，则直接尝试下一个位置
        if (rect[x][y]) {
            dfs(x, y + 1, cnt);
            return;
        }

        for (int k = Math.min(n - x, m - y); k >= 1 && isAvailable(rect, x, y, k); --k) {
            // 将长度为 k 的正方形区域标记覆盖
            fill(x, y, k, true);
            // 跳过 k 个位置开始检测
            dfs(x, y + k, cnt + 1);
            fill(x, y, k, false);
        }
    }

    private boolean isAvailable(boolean[][] rect, int x, int y, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rect[x + i][y + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void fill(int x, int y, int k, boolean flag) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rect[x + i][y + j] = flag;
            }
        }
    }
}
