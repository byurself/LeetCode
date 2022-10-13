package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * @author byu_rself
 * @date 2022/10/13 13:01
 */
public class P438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) cnt[p.charAt(i) - 'a']++;
        int a = 0, b = 0;
        for (int i = 0; i < 26; i++) if (cnt[i] != 0) a++;
        for (int l = 0, r = 0; r < s.length(); r++) {
            // 往窗口增加字符，进行词频的抵消操作，如果抵消后词频为 0，说明有一个新的字符词频与 p 完全相等
            if (--cnt[s.charAt(r) - 'a'] == 0) b++;
            // 若窗口长度超过规定，将窗口左端点右移，执行词频恢复操作，如果恢复后词频为 1（恢复前为 0），说明少了一个词频与 p 完全性相等的字符
            if (r - l + 1 > p.length() && ++cnt[s.charAt(l++) - 'a'] == 1) b--;
            if (b == a) list.add(l);
        }
        return list;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] sMap = new int[26], pMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pMap[p.charAt(i) - 'a']++;
        }
        boolean flag;
        for (int l = 0, r = 0; r < s.length(); r++) {
            flag = true;
            sMap[s.charAt(r) - 'a']++;
            if (r - l + 1 > p.length()) sMap[s.charAt(l++) - 'a']--;
            for (int i = 0; i < 26; i++) {
                if (sMap[i] != pMap[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(l);
        }
        return list;
    }
}
