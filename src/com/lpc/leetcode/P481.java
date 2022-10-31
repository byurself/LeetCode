package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 神奇字符串
 *
 * @author byu_rself
 * @date 2022/10/31 10:25
 */
public class P481 {

    public int magicalString(int n) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2));
        int i = 2, ans = 0;
        while (list.size() < n) {
            int pre = list.get(list.size() - 1);
            int cur = 3 - pre;
            for (int j = 0; j < list.get(i); j++) list.add(cur);
            i++;
        }
        for (int j = 0; j < n; j++) {
            if (list.get(j) == 1) ans++;
        }
        return ans;
    }
}
