package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除注释
 *
 * @author byu_rself
 * @date 2023/8/3 13:42
 */
public class P722 {

    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        boolean blockComment = false;
        for (String s : source) {
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                if (blockComment) {
                    if (i + 1 < n && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        // 遇到了 */
                        blockComment = false;
                        ++i;
                    }
                } else {
                    if (i + 1 < n && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        // 遇到了 /*
                        blockComment = true;
                        ++i;
                    } else if (i + 1 < n && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        // 遇到了 //
                        break;
                    } else {
                        builder.append(s.charAt(i));
                    }
                }
            }
            if (!blockComment && !builder.isEmpty()) {
                ans.add(builder.toString());
                builder.setLength(0);
            }
        }
        return ans;
    }
}
