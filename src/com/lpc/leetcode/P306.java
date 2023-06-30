package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 累加数
 *
 * @author byu_rself
 * @date 2023/6/30 9:48
 */
public class P306 {

    String num;
    int n;
    List<List<Integer>> list = new ArrayList<>();

    public boolean isAdditiveNumber(String num) {
        this.num = num;
        n = num.length();
        return dfs(0);
    }

    private boolean dfs(int u) {
        int m = list.size();
        if (u == n) return m >= 3;
        int max = num.charAt(u) == '0' ? u + 1 : n;
        List<Integer> cur = new ArrayList<>();
        for (int i = u; i < max; i++) {
            cur.add(0, num.charAt(i) - '0');
            if (m < 2 || check(list.get(m - 2), list.get(m - 1), cur)) {
                list.add(cur);
                if (dfs(i + 1)) return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    private boolean check(List<Integer> a, List<Integer> b, List<Integer> c) {
        // 高精度加法
        List<Integer> ans = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < a.size() || i < b.size(); ++i) {
            if (i < a.size()) t += a.get(i);
            if (i < b.size()) t += b.get(i);
            ans.add(t % 10);
            t /= 10;
        }
        if (t > 0) ans.add(t);

        boolean ok = c.size() == ans.size();
        for (int i = 0; i < c.size() && ok; ++i) {
            if (!c.get(i).equals(ans.get(i))) {
                ok = false;
                break;
            }
        }
        return ok;
    }
}
