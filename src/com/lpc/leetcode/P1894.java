package com.lpc.leetcode;

/**
 * 找到需要补充粉笔的学生编号
 *
 * @author byu_rself
 * @date 2023/7/29 16:45
 */
public class P1894 {

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;
        for (int c : chalk) sum += c;
        k = (int) (k % sum);
        for (int i = 0; i < n; ++i) {
            k -= chalk[i];
            if (k < 0) return i;
        }
        return -1;
    }
}
