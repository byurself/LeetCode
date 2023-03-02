package com.lpc.leetcode;

/**
 * 二进制数转字符串
 *
 * @author byu_rself
 * @date 2023/3/2 13:19
 */
public class Interview0502 {

    public String printBin(double num) {
        StringBuilder builder = new StringBuilder("0.");
        while (builder.length() < 32 && num != 0) {
            num *= 2;
            int x = (int) num;
            builder.append(x);
            num -= x;
        }
        return num == 0 ? builder.toString() : "ERROR";
    }
}
