package com.lpc.leetcode;

import java.util.*;

/**
 * 出现最频繁的偶数元素
 *
 * @author byu_rself
 * @date 2023/4/13 13:18
 */
public class P2404 {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) map.merge(num, 1, Integer::sum);
        }
        int ans = -1, max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey(), cnt = entry.getValue();
            if ((max < cnt) || (max == cnt && ans > x)) {
                max = cnt;
                ans = x;
            }
        }
        return ans;
    }
}
