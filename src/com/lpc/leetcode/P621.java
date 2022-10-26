package com.lpc.leetcode;

/**
 * 任务调度器
 *
 * @author byu_rself
 * @date 2022/10/26 16:10
 */
public class P621 {

    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        int max = 0, total = 0;
        for (char task : tasks) cnt[task - 'A']++;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, cnt[i]);
        }
        for (int i = 0; i < 26; i++) {
            total += max == cnt[i] ? 1 : 0;
        }
        return Math.max(tasks.length, (n + 1) * (max - 1) + total);
    }
}
