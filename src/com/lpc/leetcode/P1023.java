package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 驼峰式匹配
 *
 * @author byu_rself
 * @date 2023/4/14 12:48
 */
public class P1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        int length = pattern.length();
        for (String query : queries) {
            int n = query.length(), j = 0;
            boolean flag = true;
            for (int i = 0; i < n; ++i) {
                char c = query.charAt(i);
                if (j < length && pattern.charAt(j) == c) ++j;
                else if (Character.isUpperCase(c)) {
                    flag = false;
                    break;
                }
            }
            if (j != length) flag = false;
            ans.add(flag);
        }
        return ans;
    }
}
