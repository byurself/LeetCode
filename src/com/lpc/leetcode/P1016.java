package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 子串能表示从1到N数字的二进制串
 *
 * @author byu_rself
 * @date 2023/5/11 8:55
 */
public class P1016 {
    @Test
    public void solution () {
        System.out.println(Integer.numberOfLeadingZeros(4));
    }

    public boolean queryString(String s, int n) {
        if (n == 1) return s.contains("1");
        int k = 31 - Integer.numberOfLeadingZeros(n);
        if (s.length() < Math.max(n - (1 << k) + k + 1, (1 << k - 1) + k + 1)) {
            return false;
        }
        return check(s, k, n / 2 + 1, (1 << k) - 1) && check(s, k + 1, 1 << k, n);
    }

    private boolean check(String s, int k, int low, int high) {
        if (low > high) return true;
        Set<Integer> visited = new HashSet<>();
        int mask = (1 << (k - 1)) - 1;
        int x = Integer.parseInt(s.substring(0, k - 1), 2), m = s.length();
        for (int i = k - 1; i < m; ++i) {
            x = ((x & mask) << 1) | (s.charAt(i) - '0');
            if (low <= x && x <= high) visited.add(x);
        }
        return visited.size() == high - low + 1;
    }

    public boolean queryString1(String s, int n) {
        for (int i = 1; i <= n; ++i) {
            if (!s.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }
}
