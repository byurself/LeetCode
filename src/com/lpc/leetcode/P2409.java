package com.lpc.leetcode;

/**
 * 统计共同度过的日子数
 *
 * @author byu_rself
 * @date 2023/4/17 14:58
 */
public class P2409 {

    static int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] sum = new int[13];

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        for (int i = 1; i <= 12; ++i) sum[i] = sum[i - 1] + months[i - 1];
        int a1 = calculateDay(arriveAlice);
        int b1 = calculateDay(leaveAlice);
        int a2 = calculateDay(arriveBob);
        int b2 = calculateDay(leaveBob);
        return Math.max(0, Math.min(b1, b2) - Math.max(a1, a2) + 1);
    }

    private int calculateDay(String s) {
        int month = Integer.parseInt(s.substring(0, 2));
        int day = Integer.parseInt(s.substring(3));
        return sum[month - 1] + day;
    }
}
