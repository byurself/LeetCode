package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 *
 * @author byu_rself
 * @date 2023/11/14 10:40
 */
public class P93 {

    @Test
    public void solution() {
        String s = "101023";
        System.out.println(restoreIpAddresses(s));
    }

    List<String> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    char[] cs;
    int n;

    public List<String> restoreIpAddresses(String s) {
        cs = s.toCharArray();
        n = cs.length;
        dfs(0);
        return ans;
    }

    private void dfs(int idx) {
        if (path.size() > 4) return;
        if (idx == n) {
            if (path.size() == 4) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 4; ++i) {
                    builder.append(path.get(i)).append(".");
                }
                ans.add(builder.substring(0, builder.length() - 1));
            }
        } else {
            for (int i = idx; i < n; ++i) {
                int x = 0;
                for (int j = idx; j <= i; ++j) x = x * 10 + (cs[j] - '0');
                if (cs[idx] == '0' && i != idx) break;
                if (x > 255) break;
                path.add(x);
                dfs(i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
