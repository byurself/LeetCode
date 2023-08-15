package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 字符串中的查找与替换
 *
 * @author byu_rself
 * @date 2023/8/15 9:19
 */
public class P833 {

    @Test
    public void solution() {
        String s = "abcd";
        int[] indices = new int[]{0, 2};
        String[] sources = new String[]{"a", "cd"}, targets = new String[]{"eee", "ffff"};
        System.out.println(findReplaceString(s, indices, sources, targets));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = indices.length, n = s.length();
        int[] replace = new int[n];
        Arrays.fill(replace, -1);
        for (int i = 0; i < k; ++i) {
            int index = indices[i];
            if (s.startsWith(sources[i], index)) {
                replace[index] = i;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; ) {
            if (replace[i] >= 0) {
                builder.append(targets[replace[i]]);
                i += sources[replace[i]].length();
            } else {
                builder.append(s.charAt(i++));
            }
        }
        return builder.toString();
    }
}
