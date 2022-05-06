package com.lpc.leetcode;

import org.junit.Test;

/**
 * 最长公共前缀
 *
 * @author byu_rself
 * @date 2022/5/6 22:13
 */
public class P14 {

    @Test
    public void solution() {
        String[] strs = new String[]{"leet", "leetcode"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 纵向比较
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // 如果第0行的第i个字符的等于第j行的长度（说明第j行已经比较完了，则返回），或者第0行的第i个字符不等于第j行的第i个字符
                // 第0行： leetcode
                // 第1行： leet
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
