package com.lpc.leetcode;

/**
 * 隐藏个人信息
 *
 * @author byu_rself
 * @date 2023/4/1 14:53
 */
public class P831 {

    static String[] country = new String[]{"", "+*-", "+**-", "+***-"};

    public String maskPII(String s) {
        int at = s.indexOf("@");
        if (at > 0) {
            return (s.charAt(0) + "*****" + s.substring(at - 1)).toLowerCase();
        }
        s = s.replaceAll("[^0-9]", "");
        return country[s.length() - 10] + "***-***-" + s.substring(s.length() - 4);
    }

    public String maskPII1(String s) {
        StringBuilder builder = new StringBuilder();
        if (s.contains("@")) {
            String[] ss = s.split("@");
            char[] prefix = ss[0].toCharArray();
            int length1 = prefix.length;
            if (Character.isUpperCase(prefix[0])) prefix[0] = Character.toLowerCase(prefix[0]);
            if (Character.isUpperCase(prefix[length1 - 1]))
                prefix[length1 - 1] = Character.toLowerCase(prefix[length1 - 1]);
            builder.append(prefix[0]).append("*****").append(prefix[length1 - 1]).append("@");
            for (char c : ss[1].toCharArray()) {
                if (Character.isUpperCase(c)) c = Character.toLowerCase(c);
                builder.append(c);
            }
        } else {
            char[] ss = s.toCharArray();
            int n = 0;
            for (char c : ss) {
                if (Character.isDigit(c)) ++n;
            }
            int i = ss.length - 1, k = 4;
            StringBuilder sb = new StringBuilder();
            if (n == 10) builder.append("***-***-");
            else if (n == 11) builder.append("+*-***-***-");
            else if (n == 12) builder.append("+**-***-***-");
            else if (n == 13) builder.append("+***-***-***-");

            while (k > 0) {
                if (Character.isDigit(ss[i])) {
                    sb.append(ss[i]);
                    --k;
                }
                --i;
            }
            builder.append(sb.reverse());
        }

        return builder.toString();
    }
}

