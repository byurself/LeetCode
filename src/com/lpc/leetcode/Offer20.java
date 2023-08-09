package com.lpc.leetcode;

/**
 * 表示数值的字符串
 *
 * @author byu_rself
 * @date 2023/8/9 9:42
 */
public class Offer20 {

    public boolean isNumber(String s) {
        boolean isNum = false, isDot = false, iseOrE = false;
        char[] cs = s.trim().toCharArray();
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                isNum = true;
            } else if (cs[i] == '.') {
                // 只能有一个小数点 || 小数点之前不能有 e 或者 E
                if (isDot || iseOrE) return false;
                isDot = true;
            } else if (cs[i] == 'e' || cs[i] == 'E') {
                // e\E 前面必须有整数，且只能出现一个e\E
                if (!isNum || iseOrE) return false;
                iseOrE = true;
                isNum = false; // 重置 isNum，e/E之后必须为整数
            } else if (cs[i] == '+' || cs[i] == '-') {
                // 正负号只能出现在第一个位置，或者出现在 e\E 后面的第一个位置
                if (i > 0 && cs[i - 1] != 'e' && cs[i - 1] != 'E') return false;
            } else {
                // 其他非法字符
                return false;
            }
        }
        // 最后结尾肯定是数字
        return isNum;
    }
}
