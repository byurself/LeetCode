package com.lpc.leetcode;

import org.junit.Test;

/**
 * 验证IP地址
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

    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".") && checkIPv4(queryIP)) return "IPv4";
        else if (queryIP.contains(":") && checkIPv6(queryIP)) return "IPv6";
        else return "Neither";
    }

    private boolean checkIPv4(String ip) {
        char[] s = ip.toCharArray();
        int n = s.length, cnt = 0;
        for (int i = 0; i < n && cnt < 4; ) {
            int j = i, x = 0;
            while (j < n && (s[j] >= '0' && s[j] <= '9') && x <= 255) x = x * 10 + (s[j++] - '0');
            // 没有数字
            if (i == j) return false;
            // 前导零 或 数值大于 255
            if ((j - i > 1 && s[i] == '0') || x > 255) return false;
            i = j + 1;
            if (j == n) continue;
            // 存在除'.'以外的其他字符
            if (s[j] != '.') return false;
            ++cnt;
        }
        // 恰好存在三个不位于两端的'.'
        return cnt == 3 && s[0] != '.' && s[n - 1] != '.';
    }

    private boolean checkIPv6(String ip) {
        char[] s = ip.toCharArray();
        int n = s.length, cnt = 0;
        for (int i = 0; i < n && cnt < 8; ) {
            int j = i;
            while (j < n && ((s[j] >= 'a' && s[j] <= 'f') || (s[j] >= 'A' && s[j] <= 'F') || (s[j] >= '0' && s[j] <= '9'))) ++j;
            // 如果没有字符或者长度超过4
            if (i == j || j - i > 4) return false;
            i = j + 1;
            if (j == n) continue;
            // 存在除':'以外的其他字符
            if (s[j] != ':') return false;
            ++cnt;
        }
        // 恰好存在七个不位于两端的":"
        return cnt == 7 && s[0] != ':' && s[n - 1] != ':';
    }
}
