package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 标签验证器
 *
 * @author byu_rself
 * @date 2022/5/2 20:50
 */
public class P591 {

    @Test
    public void solution() {
        String code = "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>";
        System.out.println(isValid(code));
    }

    public boolean isValid(String code) {
        int n = code.length();
        Deque<String> tags = new ArrayDeque<>();

        int i = 0;
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                if (code.charAt(i + 1) == '/') {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagName = code.substring(i + 2, j);
                    if (tags.isEmpty() || !tags.peek().equals(tagName)) {
                        return false;
                    }
                    tags.pop();
                    i = j + 1;
                    if (tags.isEmpty() && i != n) {
                        return false;
                    }
                } else if (code.charAt(i + 1) == '!') {
                    if (tags.isEmpty()) {
                        return false;
                    }
                    if (i + 9 > n) {
                        return false;
                    }
                    String cdata = code.substring(i + 2, i + 9);
                    if (!"[CDATA[".equals(cdata)) {
                        return false;
                    }
                    int j = code.indexOf("]]>", i);
                    if (j < 0) {
                        return false;
                    }
                    i = j + 1;
                } else {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagName = code.substring(i + 1, j);
                    if (tagName.length() < 1 || tagName.length() > 9) {
                        return false;
                    }
                    for (int k = 0; k < tagName.length(); ++k) {
                        if (!Character.isUpperCase(tagName.charAt(k))) {
                            return false;
                        }
                    }
                    tags.push(tagName);
                    i = j + 1;
                }
            } else {
                if (tags.isEmpty()) {
                    return false;
                }
                ++i;
            }
        }
        return tags.isEmpty();
    }
}
