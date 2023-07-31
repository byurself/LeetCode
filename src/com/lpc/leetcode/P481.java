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
        char[] s = new char[n + 2];
        s[0] = 1;
        s[1] = s[2] = 2;
        char c = 2;
        for (int i = 2, j = 3; j < n; ++i) {
            c ^= 3; // 1^3=2, 2^3=1
            s[j++] = c;
            if (s[i] == 2) s[j++] = c;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) ans += 2 - s[i];
        return ans;
    }

    public int magicalString1(int n) {
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
