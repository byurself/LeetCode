package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 为运算表达式设计优先级
 *
 * @author byu_rself
 * @date 2023/12/6 11:16
 */
public class P241 {

    char[] cs;

    public List<Integer> diffWaysToCompute(String expression) {
        cs = expression.toCharArray();
        return dfs(0, cs.length - 1);
    }

    private List<Integer> dfs(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (cs[i] >= '0' && cs[i] <= '9') continue;
            List<Integer> l1 = dfs(left, i - 1); // 符号左边
            List<Integer> l2 = dfs(i + 1, right); // 符号右边
            for (int a : l1) {
                for (int b : l2) {
                    int cur = 0;
                    if (cs[i] == '+') cur = a + b;
                    else if (cs[i] == '-') cur = a - b;
                    else cur = a * b;
                    ans.add(cur);
                }
            }
        }
        // 只有数字，无运算符号
        if (ans.isEmpty()) {
            int x = 0;
            for (int i = left; i <= right; ++i) {
                x = x * 10 + (cs[i] - '0');
            }
            ans.add(x);
        }
        return ans;
    }
}
