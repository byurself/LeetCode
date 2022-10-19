package com.lpc.leetcode;

/**
 * 无法吃午餐的学生数量
 *
 * @author byu_rself
 * @date 2022/10/19 11:17
 */
public class P1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = 0, s0 = 0;
        for (int student : students) {
            if (student == 1) s1++;
            else s0++;
        }
        for (int sandwich : sandwiches) {
            if (sandwich == 1 && s1 > 0) s1--;
            else if (sandwich == 0 && s0 > 0) s0--;
            else break;
        }
        return s0 + s1;
    }
}
