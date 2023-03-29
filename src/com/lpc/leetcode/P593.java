package com.lpc.leetcode;

/**
 * 有效的正方形
 *
 * @author byu_rself
 * @date 2023/3/29 17:16
 */
public class P593 {

    long length = -1;

    public boolean validSquare(int[] a, int[] b, int[] c, int[] d) {
        return check(a, b, c) && check(a, b, d) && check(a, c, d) && check(b, c, d);
    }

    /**
     * 判断三条边是否能组成等边直角三角形
     *
     * @return 结果
     */
    boolean check(int[] a, int[] b, int[] c) {
        long l1 = (long) (a[0] - b[0]) * (a[0] - b[0]) + (long) (a[1] - b[1]) * (a[1] - b[1]);
        long l2 = (long) (a[0] - c[0]) * (a[0] - c[0]) + (long) (a[1] - c[1]) * (a[1] - c[1]);
        long l3 = (long) (b[0] - c[0]) * (b[0] - c[0]) + (long) (b[1] - c[1]) * (b[1] - c[1]);
        boolean flag = (l1 == l2 && l1 + l2 == l3) || (l1 == l3 && l1 + l3 == l2) || (l2 == l3 && l2 + l3 == l1);
        if (!flag) return false;
        if (length == -1) length = Math.min(l1, l2);
        else return length != 0 && length == Math.min(l1, l2);
        return true;
    }
}
