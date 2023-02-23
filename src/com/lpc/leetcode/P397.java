package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 整数替换
 *
 * @author byu_rself
 * @date 2023/2/23 13:54
 */
public class P397 {

    public int integerReplacement1(int n) {
        long t = n;
        int ans = 0;
        while (t != 1) {
            if (t % 2 == 0) {
                t >>= 1;
            } else {
                if (t != 3 && ((t >> 1) & 1) == 1) t++;
                else t--;
            }
            ans++;
        }
        return ans;
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (!map.containsKey(n)) {
            if (n % 2 == 0) map.put(n, 1 + integerReplacement(n / 2));
            else map.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
        }
        return map.get(n);
    }
}
