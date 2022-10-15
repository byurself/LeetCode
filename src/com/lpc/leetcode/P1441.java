package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 用栈操作构建数组
 *
 * @author byu_rself
 * @date 2022/10/15 13:05
 */
public class P1441 {

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            list.add("Push");
            if (target[j] != i) list.add("Pop");
            else j++;
        }
        return list;
    }
}
