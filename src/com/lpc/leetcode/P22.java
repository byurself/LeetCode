package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author byu_rself
 * @date 2022/10/19 12:09
 */
public class P22 {

    List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);
        return list;
    }

    public void backtrack(StringBuilder builder, int open, int close, int max) {
        if (builder.length() == max * 2) {
            list.add(builder.toString());
            return;
        }
        if (open < max) {
            builder.append('(');
            backtrack(builder, open + 1, close, max);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (close < open) {
            builder.append(')');
            backtrack(builder, open, close + 1, max);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
