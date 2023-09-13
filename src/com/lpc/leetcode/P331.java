package com.lpc.leetcode;

/**
 * 验证二叉树的前序序列化
 *
 * @author byu_rself
 * @date 2023/9/13 10:12
 */
public class P331 {

    public boolean isValidSerialization(String s) {
        String[] ss = s.split(",");
        int n = ss.length;
        int in = 0, out = 0;
        for (int i = 0; i < n; ++i) {
            if (!ss[i].equals("#")) out += 2;
            if (i != 0) ++in;
            if (i != n - 1 && out <= in) return false;
        }
        return in == out;
    }
}
