package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重新规划路线
 *
 * @author byu_rself
 * @date 2023/12/7 10:41
 */
public class P1466 {

    List<int[]>[] g;

    public int minReorder(int n, int[][] connections) {
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] c : connections) {
            int a = c[0], b = c[1];
            g[a].add(new int[]{b, 1});
            g[b].add(new int[]{a, 0});
        }
        return dfs(0, -1);
    }

    private int dfs(int x, int pa) {
        int ans = 0;
        for (int[] e : g[x]) {
            int y = e[0], c = e[1];
            if (y != pa) {
                ans += c + dfs(y, x);
            }
        }
        return ans;
    }
}
