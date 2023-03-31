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

    private boolean dfs(int state, int sum, int maxChoosableInteger, int desiredTotal) {
        if (cache.containsKey(state)) return cache.get(state);
        for (int x = 1; x <= maxChoosableInteger; ++x) {
            if (((1 << x) & state) == 0) { // 若x未被使用
                if (sum + x >= desiredTotal) {
                    cache.put(state, true);
                    return true;
                }
                // 当前玩家选择x后，判断对方一定会输吗?若对方一定输，则当前玩家一定赢
                if (!dfs((1 << x) | state, sum + x, maxChoosableInteger, desiredTotal)) {
                    cache.put(state, true);
                    return true;
                }
            }
        }
        cache.put(state, false);
        return false;
    }
}
