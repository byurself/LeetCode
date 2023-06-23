package com.lpc.leetcode;

/**
 * 数组中字符串的最大值
 *
 * @author byu_rself
 * @date 2023/6/23 14:12
 */
public class P2496 {

    public int maximumValue(String[] strs) {
        int ans = 0;
        for (String s : strs) {
            boolean flag = false;
            for (char c : s.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                ans = Math.max(ans, s.length());
            } else {
                ans = Math.max(ans, Integer.parseInt(s));
            }
        }
        return ans;
    }
}
