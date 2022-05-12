package com.lpc.leetcode;

import org.junit.Test;

/**
 * Delete Columns to Make Sorted
 *
 * @author byu_rself
 * @date 2022/5/12 10:30
 */
public class P944 {

    @Test
    public void solution() {
        String[] strs = new String[]{"zyx", "wvu", "tsr"};
        System.out.println(minDeletionSize(strs));
    }

    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
