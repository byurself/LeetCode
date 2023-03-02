package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 我能赢吗
 *
 * @author byu_rself
 * @date 2022/5/22 0:01
 */
public class P464 {

    @Test
    public void solution() {
        int maxChoosableInteger = 10;
        int desiredTotal = 11;
        System.out.println(Integer.toBinaryString((1 << 3) & 8));
    }

    Map<Integer, Boolean> cache = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) return false;
        return dfs(0, 0, maxChoosableInteger, desiredTotal);
    }

    private boolean dfs(int use, int sum, int maxChoosableInteger, int desiredTotal) {
        if (cache.containsKey(use)) return cache.get(use);
        for (int i = 1; i <= maxChoosableInteger; i++) {
            // 若i已被使用过，则跳过
            if (((1 << i) & use) > 0) continue;
            if (sum + i >= desiredTotal) {
                cache.put(use, true);
                return true;
            }
            if (!dfs((1 << i) | use, sum + i, maxChoosableInteger, desiredTotal)) {
                cache.put(use, true);
                return true;
            }
        }
        cache.put(use, false);
        return false;
    }

    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

    public boolean canIWin1(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        return dfs1(maxChoosableInteger, 0, desiredTotal, 0);
    }

    public boolean dfs1(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        if (!map.containsKey(usedNumbers)) {
            boolean res = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                if (((usedNumbers >> i) & 1) == 0) {
                    if (i + 1 + currentTotal >= desiredTotal) {
                        res = true;
                        break;
                    }
                    if (!dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1)) {
                        res = true;
                        break;
                    }
                }
            }
            map.put(usedNumbers, res);
        }
        return map.get(usedNumbers);
    }
}
