package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 判定是否互为字符重排
 *
 * @author byu_rself
 * @date 2022/9/27 11:02
 */
public class Interview0102 {

    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!map.containsKey(c)) return false;
            Integer cnt = map.get(c);
            if (--cnt == 0) map.remove(c);
            else map.put(c, cnt);
        }
        return true;
    }
}
