package com.lpc.leetcode;

/**
 * 有效数字
 *
 * @author byu_rself
 * @date 2023/7/4 9:56
 */
public class P65 {

    public boolean isNumber(String s) {
        char[] cs = s.toCharArray();
        int index = -1, n = cs.length;
        for (int i = 0; i < n; ++i) {
            if (cs[i] == 'e' || cs[i] == 'E') {
                if (index == -1) index = i;
                else return false;
            }
        }
        boolean ans = true;
        if (index == -1) {
            // 没有 e/E
            ans &= check(cs, 0, n - 1, false);
        } else {
            // 存在 e/E
            ans &= check(cs, 0, index - 1, false);
            ans &= check(cs, index + 1, n - 1, true);
        }
        return ans;
    }

    private boolean check(char[] cs, int start, int end, boolean mustInteger) {
        if (start > end) return false;
        if (cs[start] == '+' || cs[start] == '-') ++start;
        boolean hasDot = false, hasNum = false;
        for (int i = start; i <= end; ++i) {
            if (cs[i] == '.') {
                // 已经出现过小数点或者必须为整数
                if (hasDot || mustInteger) return false;
                hasDot = true;
            } else if (cs[i] >= '0' && cs[i] <= '9') {
                // 出现数字
                hasNum = true;
            } else {
                // 出现其他字母
                return false;
            }
        }
        return hasNum;
    }
}
