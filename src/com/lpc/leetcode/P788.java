package com.lpc.leetcode;

import org.junit.Test;

/**
 * 旋转数字
 *
 * @author byu_rself
 * @date 2022/9/25 20:41
 */
public class P788 {

    @Test
    public void solution() {
        System.out.println(rotatedDigits(10));
    }

    static int[] flag = new int[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            boolean valid = true, diff = false;
            for (int j = 0; j < num.length(); j++) {
                char c = num.charAt(j);
                if (flag[c - '0'] == -1) {
                    valid = false;
                    break;
                } else if (flag[c - '0'] == 1) {
                    diff = true;
                }
            }
            if (valid && diff) ans++;
        }
        return ans;
    }
}
