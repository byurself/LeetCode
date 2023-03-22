package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 无矛盾的最佳球队
 *
 * @author byu_rself
 * @date 2023/3/22 13:43
 */
public class P1626 {

    int[] tree;
    int maxAge;

    private int lowbit(int x) {
        return x & -x;
    }

    private void update(int x, int val) {
        for (int i = x; i <= maxAge; i += lowbit(i)) {
            tree[i] = Math.max(tree[i], val);
        }
    }

    private int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans = Math.max(ans, tree[i]);
        }
        return ans;
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length, ans = 0;
        maxAge = Arrays.stream(ages).max().getAsInt();
        tree = new int[maxAge + 1];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) arr[i] = new int[]{scores[i], ages[i]};
        // 按分数从小到大排序，若分数相同，则按年龄从小到大排序
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < n; ++i) {
            int score = arr[i][0], age = arr[i][1];
            int cur = score + query(age);
            update(age, cur);
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public int bestTeamScore1(int[] scores, int[] ages) {
        int n = scores.length, ans = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) arr[i] = new int[]{scores[i], ages[i]};
        // 按分数从小到大排序，若分数相同，则按年龄从小到大排序
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i][1] >= arr[j][1]) f[i] = Math.max(f[i], f[j]);
            }
            f[i] += arr[i][0];
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
