package com.lpc.leetcode;

/**
 * 柠檬水找零
 *
 * @author byu_rself
 * @date 2023/7/22 14:24
 */
public class P860 {

    public boolean lemonadeChange(int[] bills) {
        int cnt5 = 0, cnt10 = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5 -> ++cnt5;
                case 10 -> {
                    --cnt5;
                    ++cnt10;
                }
                case 20 -> {
                    if (cnt10 > 0) {
                        --cnt10;
                        --cnt5;
                    } else {
                        cnt5 -= 3;
                    }
                }
            }
            if (cnt5 < 0) return false;
        }
        return true;
    }
}
