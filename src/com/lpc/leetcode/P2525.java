package com.lpc.leetcode;

/**
 * 根据规则将箱子分类
 *
 * @author byu_rself
 * @date 2023/10/20 9:07
 */
public class P2525 {

    private static final int T = (int) 1e4;
    private static final long V = (long) 1e9;

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = false;
        long v = (long) length * width * height;
        if (length >= T || width >= T || height >= T || v >= V) {
            bulky = true;
        }
        boolean heavy = mass >= 100;
        if (bulky && heavy) return "Both";
        else if (bulky) return "Bulky";
        else if (heavy) return "Heavy";
        else return "Neither";
    }
}
