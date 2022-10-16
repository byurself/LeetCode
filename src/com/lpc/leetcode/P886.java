package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 可能的二分法
 *
 * @author byu_rself
 * @date 2022/10/16 22:55
 */
public class P886 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i < list.length; i++) list[i] = new ArrayList<>(n + 1);
        for (int[] dislike : dislikes) {
            list[dislike[0]].add(dislike[1]);
            list[dislike[1]].add(dislike[0]);
        }
        int[] record = new int[n + 1];
        for (int i = 1; i < list.length; i++) {
            if (record[i] == 0 && !dfs(list, record, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(List<Integer>[] list, int[] record, int index, int group) {
        record[index] = group;
        for (int i = 0; i < list[index].size(); i++) {
            int num = list[index].get(i);
            if (record[num] == group) return false;
            if (record[num] == 0 && !dfs(list, record, num, group * -1)) return false;
        }
        return true;
    }
}
