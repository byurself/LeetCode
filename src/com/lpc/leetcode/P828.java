package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 统计子串中的唯一字符
 *
 * @author byu_rself
 * @date 2022/9/6 10:53
 */
public class P828 {

    @Test
    public void solution() {
        String s = "ABC";
        System.out.println(uniqueLetterString(s));
    }

    public int uniqueLetterString(String s) {
        // 存储last字符前一个字符所在位置
        int[] lastIndexMap = new int[26];
        // 存储cur字符当前所处位置
        int[] curIndexMap = new int[26];
        Arrays.fill(lastIndexMap, -1);
        Arrays.fill(curIndexMap, -1);
        char[] cs = s.toCharArray();
        int ans = 0, length = cs.length;
        for (int i = 0; i < length; i++) {
            // next字符
            int index = cs[i] - 'A';
            // cur字符的索引不是-1，计算cur字符的贡献值
            if (curIndexMap[index] > -1) {
                ans += (curIndexMap[index] - lastIndexMap[index]) * (i - curIndexMap[index]);
            }
            lastIndexMap[index] = curIndexMap[index];
            curIndexMap[index] = i;
        }
        // 计算最后next字符的贡献值，最后一个位置就是s.length()
        for (int i = 0; i < 26; i++) {
            if (curIndexMap[i] > -1) {
                ans += (curIndexMap[i] - lastIndexMap[i]) * (s.length() - curIndexMap[i]);
            }
        }
        return ans;
    }
}
