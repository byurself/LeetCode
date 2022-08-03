package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 有序队列
 *
 * @author byu_rself
 * @date 2022/8/3 10:50
 */
public class P899 {

    @Test
    public void solution() {
        String s = "kuh";
        int k = 1;
        System.out.println(orderlyQueue(s, k));
    }

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            // 模拟往后移一个元素
            StringBuilder sb = new StringBuilder(s);
            for (int i = 1; i < s.length(); i++) {
                // 第一个元素移动到最后
                sb.append(sb.charAt(0)).deleteCharAt(0);
                if (sb.toString().compareTo(s) < 0) {
                    s = sb.toString();
                }
            }
            return s;
        } else {
            // 直接排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
