package com.lpc.leetcode;

import java.util.TreeSet;

/**
 * 无限集中的最小数字
 *
 * @author byu_rself
 * @date 2023/11/29 9:03
 */
public class P2336 {

    TreeSet<Integer> set = new TreeSet<>();

    public P2336() {
        for (int i = 1; i <= 1000; ++i) {
            set.add(i);
        }
    }

    public int popSmallest() {
        return set.pollFirst();
    }

    public void addBack(int num) {
        set.add(num);
    }
}
