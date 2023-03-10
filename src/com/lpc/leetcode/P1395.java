package com.lpc.leetcode;

import org.junit.Test;

/**
 * 统计作战单位数
 *
 * @author byu_ratingelf
 * @date 2022/9/17 14:55
 */
public class P1395 {

    @Test
    public void solution() {
        int[] rating = new int[]{2, 5, 3, 4, 1};
        System.out.println(numTeams(rating));
    }

    private static final int N = (int) 1e5 + 10;
    private static int[] tr = new int[N];

    /**
     * 返回二进制最低位的1所对应的值
     */
    private int lowbit(int x) {
        return x & -x;
    }

    private void update(int x, int v) {
        for (int i = x; i < N; i += lowbit(i)) tr[i] += v;
    }

    private int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tr[i];
        return ans;
    }

    public int numTeams(int[] rating) {
        int n = rating.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int a = rating[i];
            for (int j = i + 1; j < n; j++) {
                int b = rating[j];
                if (a < b) ans += query(b - 1) - query(a);
                else ans += query(a - 1) - query(b);
                update(b, 1);
            }
            for (int j = i + 1; j < n; j++) update(rating[j], -1);
        }
        return ans;
    }

    /**
     * 枚举中间点
     */
    public int numTeams1(int[] rating) {
        int n = rating.length, ans = 0;
        for (int j = 1; j < n - 1; ++j) {
            int iLess = 0, iMore = 0;
            int kLess = 0, kMore = 0;
            for (int i = 0; i < j; ++i) {
                if (rating[i] < rating[j]) ++iLess;
                else if (rating[i] > rating[j]) ++iMore;
            }
            for (int k = j + 1; k < n; ++k) {
                if (rating[k] < rating[j]) ++kLess;
                else if (rating[k] > rating[j]) ++kMore;
            }
            ans += iLess * kMore + iMore * kLess;
        }
        return ans;
    }
}
