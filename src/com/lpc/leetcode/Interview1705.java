package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 字母与数字
 *
 * @author byu_rself
 * @date 2023/3/11 16:22
 */
public class Interview1705 {

    public String[] findLongestSubarray(String[] array) {
        int sum = 0, max = 0, k = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < array.length; ++i) {
            sum += array[i].charAt(0) >= 'A' ? 1 : -1;
            if (map.containsKey(sum)) {
                int j = map.get(sum);
                if (max < i - j) {
                    max = i - j;
                    k = j + 1;
                }
            } else {
                map.put(sum, i);
            }
        }
        String[] ans = new String[max];
        System.arraycopy(array, k, ans, 0, max);
        return ans;
    }
}
