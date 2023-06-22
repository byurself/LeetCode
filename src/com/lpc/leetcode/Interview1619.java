package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 水域大小
 *
 * @author byu_rself
 * @date 2023/6/22 16:17
 */
public class Interview1619 {

    int m, n;
    int[][] land;

    public int[] pondSizes(int[][] land) {
        this.land = land;
        m = land.length;
        n = land[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (land[i][j] == 0) {
                    list.add(dfs(i, j));
                }
            }
        }
        // 简洁，运行速度慢
        // return list.stream().sorted().mapToInt(Integer::valueOf).toArray();

        // 麻烦，运行速度快
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }

    private int dfs(int i, int j) {
        int ans = 1;
        land[i][j] = 1;
        for (int x = i - 1; x <= i + 1; ++x) {
            for (int y = j - 1; y <= j + 1; ++y) {
                if (x < 0 || x >= m || y < 0 || y >= n || land[x][y] != 0) continue;
                ans += dfs(x, y);
            }
        }
        return ans;
    }
}
