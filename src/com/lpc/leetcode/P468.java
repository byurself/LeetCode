package com.lpc.leetcode;

import org.junit.Test;

/**
 * Validate IP Address
 *
 * @author byu_rself
 * @date 2022/5/29 13:51
 */
public class P468 {

    @Test
    public void solution() {
        String queryIp = "172.16.254.1";
        System.out.println(validIPAddress(queryIp));
    }

    public String validIPAddress(String ip) {
        if (ip.contains(".") && check4(ip)) return "IPv4";
        if (ip.contains(":") && check6(ip)) return "IPv6";
        return "Neither";
    }
    boolean check4(String ip) {
        int n = ip.length(), cnt = 0;
        char[] cs = ip.toCharArray();
        for (int i = 0; i < n && cnt <= 3; ) {
            // 找到连续数字段，以 x 存储
            int j = i, x = 0;
            while (j < n && cs[j] >= '0' && cs[j] <= '9' && x <= 255) x = x * 10 + (cs[j++] - '0');
            // 非 item 字符之间没有 item
            if (i == j) return false;
            // 含前导零 或 数值大于 255
            if ((j - i > 1 && cs[i] == '0') || (x > 255)) return false;
            i = j + 1;
            if (j == n) continue;
            // 存在除 . 以外的其他非数字字符
            if (cs[j] != '.') return false;
            cnt++;
        }
        // 恰好存在 3 个不位于两端的 .
        return cnt == 3 && cs[n - 1] != '.';
    }
    boolean check6(String ip) {
        int n = ip.length(), cnt = 0;
        char[] cs = ip.toCharArray();
        for (int i = 0; i < n && cnt <= 7; ) {
            int j = i;
            while (j < n && ((cs[j] >= 'a' && cs[j] <= 'f') || (cs[j] >= 'A' && cs[j] <= 'F') || (cs[j] >= '0' && cs[j] <= '9'))) j++;
            // 非 item 字符之间没有 item 或 长度超过 4
            if (i == j || j - i > 4) return false;
            i = j + 1;
            if (j == n) continue;
            // 存在除 : 以外的其他非数字字符
            if (cs[j] != ':') return false;
            cnt++;
        }
        // 恰好存在 7 个不位于两段的 :
        return cnt == 7 && cs[n - 1] != ':';
    }
}
