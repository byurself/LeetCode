package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 统计范围内的元音字符串数
 *
 * @author byu_rself
 * @date 2023/11/7 9:24
 */
public class P2586 {

    private static final Set<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; ++i) {
            String s = words[i];
            if (set.contains(s.charAt(0)) && set.contains(s.charAt(s.length() - 1))) {
                ++ans;
            }
        }
        return ans;
    }
}
