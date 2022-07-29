package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 解密消息
 *
 * @author byu_rself
 * @date 2022/7/29 13:16
 */
public class P2325 {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char t = 'a';
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!map.containsKey(c) && c != ' ') {
                map.put(c, t++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                sb.append(' ');
            } else {
                sb.append(map.get(c));
            }
        }
        return sb.toString();
    }
}
