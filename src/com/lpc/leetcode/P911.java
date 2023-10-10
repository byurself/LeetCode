package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在线选举
 *
 * @author byu_rself
 * @date 2023/10/10 10:42
 */
public class P911 {

    List<int[]> list = new ArrayList<>();

    public P911(int[] persons, int[] times) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < persons.length; ++i) {
            map.merge(persons[i], 1, Integer::sum);
            if (map.get(persons[i]) >= max) {
                max = map.get(persons[i]);
                list.add(new int[]{times[i], persons[i]});
            }
        }
    }

    public int q(int t) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (list.get(mid)[0] <= t) left = mid;
            else right = mid - 1;
        }
        return list.get(right)[0] <= t ? list.get(right)[1] : 0;
    }
}
