package com.lpc.leetcode;

/**
 * 相似度为K的字符串
 * @author byu_rself
 * @date 2022/9/21 19:55
 */
public class P854 {

    private int min = Integer.MAX_VALUE;

    private int kSimilarity(String s1, String s2) {
        return execute(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    public int execute(char[] sc1, char[] sc2, int start, int current) {
        if (current >= min) return min;
        if (start == sc1.length - 1) return min = Math.min(current, min);

        for (int i = start; i < sc1.length; i++) {
            if (sc1[i] != sc2[i]) {
                for (int j = i + 1; j < sc2.length; j++) {
                    if (sc2[j] == sc1[i] && sc2[j] != sc1[j]) {
                        swap(sc2, i, j); // 交换
                        execute(sc1, sc2, i + 1, current + 1);
                        swap(sc2, i, j); // 回溯
                        if (sc2[i] == sc1[j]) break; // 如果sc1和sc2的i位于j位互为相等，那么就是最优交换
                    }
                }
                return min;
            }
        }
        return min = Math.min(current, min);
    }

    private void swap(char[] sc, int i, int j) {
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
    }
}
