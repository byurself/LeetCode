package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计点对的数目
 *
 * @author byu_rself
 * @date 2023/8/23 9:40
 */
public class P1782 {

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        // degree[i] 表示与点 i 相连的边的数目
        int[] degree = new int[n + 1]; // 节点编号从 1 到 n
        Map<Integer, Integer> cntE = new HashMap<>();
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            if (x > y) {
                // 交换 x 和 y，因为 1-2 和 2-1 算同一条边
                int tmp = x;
                x = y;
                y = tmp;
            }
            ++degree[x];
            ++degree[y];
            // 统计每条边的出现次数
            // 用一个 int 存储两个不超过 65535 的数
            cntE.merge(x << 16 | y, 1, Integer::sum); // cntE[x<<16|y]++
        }

        int[] ans = new int[queries.length];
        int[] sortedDegree = degree.clone();
        Arrays.sort(sortedDegree); // 排序，为了双指针
        for (int j = 0; j < queries.length; ++j) {
            int q = queries[j];
            int left = 1, right = n;
            while (left < right) {
                if (sortedDegree[left] + sortedDegree[right] <= q) {
                    ++left;
                } else {
                    ans[j] += right - left;
                    --right;
                }
            }
            for (Map.Entry<Integer, Integer> e : cntE.entrySet()) {
                int k = e.getKey(), c = e.getValue();
                int s = degree[k >> 16] + degree[k & 0xffff]; // 取出 k 的高 16 位和低 16 位
                if (s > q && s - c <= q) {
                    --ans[j];
                }
            }
        }
        return ans;
    }
}
