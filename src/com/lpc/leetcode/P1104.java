package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树寻路
 *
 * @author byu_rself
 * @date 2023/9/3 20:46
 */
public class P1104 {

    // 第 level 层的起始节点值
    private int getStart(int level) {
        return (int) Math.pow(2, level - 1);
    }

    // 第 level 层的结束节点值
    private int getEnd(int level) {
        return getStart(level) * 2 - 1;
    }

    public List<Integer> pathInZigZagTree(int n) {
        int level = 1;
        while (getEnd(level) < n) ++level; // n 所在的层数

        int[] ans = new int[level];
        int idx = level - 1, cur = n;
        while (idx >= 0) {
            ans[idx--] = cur;
            int total = (int) Math.pow(2, level - 1);
            int start = getStart(level), end = getEnd(level);
            if (level % 2 == 0) {
                // 当前层为偶数层，则当前层节点「从右往左」数值递增，相应计算上一层下标也应该「从右往左」
                int j = total / 2;
                for (int i = start; i <= end; i += 2, --j) {
                    if (i == cur || (i + 1) == cur) break;
                }
                int prevStart = getStart(level - 1);
                while (j-- > 1) ++prevStart;
                cur = prevStart;
            } else {
                // 当前层为奇数层，则当前层节点「从左往右」数值递增，相应计算上一层下标也应该「从左往右」
                int j = 1;
                for (int i = start; i <= end; i += 2, ++j) {
                    if (i == cur || (i + 1) == cur) break;
                }
                int prevEnd = getEnd(level - 1);
                while (j-- > 1) --prevEnd;
                cur = prevEnd;
            }
            --level;
        }
        List<Integer> list = new ArrayList<>();
        for (int x : ans) list.add(x);
        return list;
    }
}
