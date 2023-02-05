package com.lpc.leetcode;

/**
 * 替换隐藏数字得到的最晚时间
 *
 * @author byu_rself
 * @date 2023/2/5 12:08
 */
public class P1736 {

    public String maximumTime(String time) {
        String[] t = time.split(":");
        String hh = t[0];
        String mm = t[1];
        StringBuilder builder = new StringBuilder();
        builder.append(hh.charAt(0) == '?' ? (hh.charAt(1) >= '4' && hh.charAt(1) <= '9' ? '1' : '2') : hh.charAt(0));
        builder.append(hh.charAt(1) == '?' ? (builder.charAt(0) == '2' ? '3' : '9') : hh.charAt(1));
        builder.append(':');
        builder.append(mm.charAt(0) == '?' ? '5' : mm.charAt(0));
        builder.append(mm.charAt(1) == '?' ? '9' : mm.charAt(1));
        return builder.toString();
    }
}
