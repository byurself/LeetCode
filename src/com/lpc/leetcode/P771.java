package com.lpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 宝石与石头
 *
 * @author byu_rself
 * @date 2023/7/24 9:49
 */
public class P771 {

    public int numJewelsInStones(String jewels, String stones) {
        int[] s = new int[128];
        for (int i = 0; i < jewels.length(); ++i) {
            s[jewels.charAt(i)] = 1;
        }
        int ans = 0;
        for (int i = 0; i < stones.length(); ++i) {
            ans += s[stones.charAt(i)];
        }
        return ans;
    }

    /*public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); ++i) {
            set.add(jewels.charAt(i));
        }
        int ans = 0;
        for (int i = 0; i < stones.length(); ++i) {
            if (set.contains(stones.charAt(i))) ++ans;
        }
        return ans;
    }*/
}
