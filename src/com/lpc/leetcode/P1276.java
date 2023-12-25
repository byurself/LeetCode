package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 不浪费原料的汉堡制作方案
 *
 * @author byu_rself
 * @date 2023/12/25 10:04
 */
public class P1276 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2 || cheeseSlices * 4 < tomatoSlices) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(tomatoSlices / 2 - cheeseSlices);
        ans.add(cheeseSlices * 2 - tomatoSlices / 2);
        return ans;
    }
}
