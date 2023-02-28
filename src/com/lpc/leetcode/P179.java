package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 最大数
 *
 * @author byu_rself
 * @date 2023/2/28 11:18
 */
public class P179 {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = nums[i] + "";
        Arrays.sort(ss, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder builder = new StringBuilder();
        for (String s : ss) builder.append(s);
        int len = builder.length(), k = 0;
        while (k < len - 1 && builder.charAt(k) == '0') k++; // 去除前导零
        return builder.substring(k);
    }
}
