package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 游戏中弱角色的数量
 *
 * @author byu_rself
 * @date 2023/2/9 14:48
 */
public class P1996 {

    public int numberOfWeakCharacters(int[][] properties) {
        // 攻击值不同的，按攻击值从大到小排序；攻击值相同的，按防御值从小到大排序
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int res = 0, max = 0;
        for (int[] property : properties) {
            if (property[1] < max) res++;
            else max = property[1];
        }
        return res;
    }
}
