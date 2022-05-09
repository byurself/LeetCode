package com.lpc.leetcode;

import org.junit.Test;

/**
 * 增减字符串匹配
 *
 * @author byu_rself
 * @date 2022/5/9 9:10
 */
public class P942 {

    @Test
    public void solution() {
        String s = "IDID";
        for (int i : diStringMatch(s)) {
            System.out.println(i);
        }
    }

    /**
     * 贪心算法
     *
     * @param s
     * @return
     */
    public int[] diStringMatch(String s) {
        int[] perm = new int[s.length() + 1];
        int min = 0, max = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = min++;
            } else if (s.charAt(i) == 'D') {
                perm[i] = max--;
            }
        }
        perm[s.length()] = min;
        return perm;
    }
}
