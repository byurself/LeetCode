package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 拆分成最多数目的正偶数之和
 *
 * @author byu_rself
 * @date 2023/7/6 9:01
 */
public class P2178 {

    @Test
    public void solution() {
        List<Long> list = maximumEvenSplit(28);
        list.forEach(System.out::println);
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 == 1) return ans;
        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        ans.add(ans.remove(ans.size() - 1) + finalSum);
        return ans;
    }
}
