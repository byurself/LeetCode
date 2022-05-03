package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 重新排列日志文件
 *
 * @author byu_rself
 * @date 2022/5/3 9:30
 */
public class P937 {

    @Test
    public void solution() {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] array = reorderLogFiles(logs);
        for (String s : array) {
            System.out.println(s);
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        // 如果返回1，就是升序，-1则是降序。
        Arrays.sort(logs, (o1, o2) -> compare(o1, o2));
        return logs;
    }

    private int compare(String log1, String log2) {
        int s1 = log1.indexOf(' ') + 1;
        int s2 = log2.indexOf(' ') + 1;
        if (Character.isDigit(log1.charAt(s1)) && Character.isDigit(log2.charAt(s2))) {
            return 0;
        } else if (Character.isDigit(log1.charAt(s1))) {
            return 1;
        } else if (Character.isDigit(log2.charAt(s2))) {
            return -1;
        } else {
            int cmp = log1.substring(s1).compareTo(log2.substring(s2));
            if (cmp == 0) return log1.compareTo(log2);
            else return cmp;
        }
    }

}
