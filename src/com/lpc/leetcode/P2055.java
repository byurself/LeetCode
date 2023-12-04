package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 蜡烛之间的盘子
 *
 * @author byu_rself
 * @date 2023/12/4 9:27
 */
public class P2055 {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length(), m = queries.length;
        int[] ans = new int[m], sum = new int[n + 1], left = new int[n], right = new int[n];
        for (int i = 0, j = n - 1, p = -1, q = -1; i < n; ++i, --j) {
            if (s.charAt(i) == '|') p = i;
            if (s.charAt(j) == '|') q = j;
            left[i] = p;
            right[j] = q;
            sum[i + 1] = sum[i] + (s.charAt(i) == '*' ? 1 : 0);
        }
        for (int i = 0; i < m; ++i) {
            int a = queries[i][0], b = queries[i][1];
            int x = right[a], y = left[b];
            if (x != -1 && x <= y) ans[i] = sum[y + 1] - sum[x];
        }
        return ans;
    }

    /*public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length(), m = queries.length;
        int[] ans = new int[m], sum = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == '|') list.add(i);
            sum[i + 1] = sum[i] + (c == '*' ? 1 : 0);
        }
        if (list.isEmpty()) return ans;
        for (int i = 0; i < m; ++i) {
            int a = queries[i][0], b = queries[i][1];
            int c = -1, d = -1;
            // 左边界
            int left = 0, right = list.size() - 1;
            while (left < right) {
                int mid = left + right >> 1;
                if (list.get(mid) >= a) right = mid;
                else left = mid + 1;
            }
            if (list.get(right) >= a) c = list.get(right);
            else continue;
            // 右边界
            left = 0;
            right = list.size() - 1;
            while (left < right) {
                int mid = left + right + 1 >> 1;
                if (list.get(mid) <= b) left = mid;
                else right = mid - 1;
            }
            if (list.get(right) <= b) d = list.get(right);
            else continue;
            if (c <= d) ans[i] = sum[d + 1] - sum[c];
        }
        return ans;
    }*/
}
