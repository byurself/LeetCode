package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * First Letter to Appear Twice
 *
 * @author byu_rself
 * @date 2022/7/24 16:14
 */
public class P6124 {

    @Test
    public void solution() {
        String s = "abcdd";
        System.out.println(repeatedCharacter(s));
    }

    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return c;
            }
            set.add(c);
        }
        return ' ';
    }
}
