package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Unique Email Addresses
 *
 * @author byu_rself
 * @date 2022/6/4 22:30
 */
public class P929 {

    @Test
    public void solution() {
        String[] emails = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            StringBuilder sb = new StringBuilder();
            int n = s.length(), i = 0;
            boolean ok = true;
            while (i < n) {
                char c = s.charAt(i);
                if (c == '@') break;
                if (c == '.' && ++i >= 0) continue;
                if (c == '+') ok = false;
                if (ok) sb.append(c);
                i++;
            }
            set.add(sb.append(s.substring(i)).toString());
        }
        return set.size();
    }
}
