package com.lpc.leetcode;

/**
 * 检查替换后的词是否有效
 *
 * @author byu_rself
 * @date 2023/5/3 19:39
 */
public class P1003 {

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 3 != 0) return false;
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            stack.append(c);
            if (stack.length() >= 3 && "abc".equals(stack.substring(stack.length() - 3))) {
                stack.delete(stack.length() - 3, stack.length());
            }
        }
        return stack.isEmpty();
    }
}
