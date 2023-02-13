package com.lpc.leetcode;

/**
 * 超级洗衣机
 *
 * @author byu_rself
 * @date 2023/2/13 14:40
 */
public class P517 {

    public int findMinMoves(int[] machines) {
        int sum = 0, n = machines.length;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % n != 0) return -1;
        int ans = 0, cnt = 0, avg = sum / n;
        for (int machine : machines) {
            cnt += machine - avg;
            ans = Math.max(ans, Math.max(machine - avg, Math.abs(cnt)));
        }
        return ans;
    }
}
