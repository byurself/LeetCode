package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 *
 * @author byu_rself
 * @date 2022/4/29 9:21
 */
public class P3 {
    @Test
    public void solution() {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(getLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length, ans = 0;
        int[] cnt = new int[128];
        for (int l = 0, r = 0; r < length; r++) {
            char c = chars[r];
            cnt[c]++;
            while (cnt[c] > 1) {
                --cnt[chars[l++]];
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    // 获取最长字串长度
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // 如果出现重复字符，更新起始位置到重复字符的后一个位置
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
            }
            // 向map中存入字符，如果该字符已存在，则更新下标位置
            map.put(s.charAt(i), i + 1);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    // 输出最长子串
    public String getLongestSubstring(String s) {
        if (s.length() == 0) {
            return null;
        }

        int startIndex = 0;
        int left = 0;
        int max = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // 如果出现重复字符，更新起始位置到重复字符的后一个位置
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
            }
            // 向map中存入字符，如果该字符已存在，则更新下标位置
            map.put(s.charAt(i), i + 1);
            max = Math.max(max, i - left + 1);
            if (len < max) {
                len = max;
                startIndex = left;
            }
        }
        return s.substring(startIndex, startIndex + max);
    }
}
