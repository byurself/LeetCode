package com.lpc.leetcode;

/**
 * 将标题首字母大写
 *
 * @author byu_rself
 * @date 2024/3/11 9:27
 */
public class P2129 {

    public String capitalizeTitle(String title) {
        StringBuilder builder = new StringBuilder();
        for (String s : title.split(" ")) {
            if (s.length() <= 2) {
                builder.append(s.toLowerCase());
            } else {
                builder.append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase());
            }
            builder.append(" ");
        }
        return builder.substring(0, builder.length() - 1);
    }
}
