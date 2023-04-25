package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 按身高排序
 *
 * @author byu_rself
 * @date 2023/4/25 18:43
 */
public class P2418 {

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        int[][] index = new int[n][2];
        for (int i = 0; i < n; ++i) {
            index[i] = new int[]{heights[i], i};
        }
        Arrays.sort(index, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = names[index[i][1]];
        }
        return ans;
    }

    public String[] sortPeople1(String[] names, int[] heights) {
        int n = names.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; ++i) index[i] = i;
        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = names[index[i]];
        }
        return ans;
    }
}
