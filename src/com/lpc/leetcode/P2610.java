package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 转换二维数组
 *
 * @author byu_rself
 * @date 2025/3/19 11:23
 */
public class P2610 {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] cnt = new int[nums.length + 1];
        for (int x : nums) {
            if (cnt[x] == ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(cnt[x]).add(x);
            cnt[x]++;
        }
        return ans;
    }

    /*public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!map.isEmpty()) {
            List<Integer> list = new ArrayList<>(map.keySet());
            ans.add(list);
            for (Integer x : list) {
                int cnt = map.get(x) - 1;
                if (cnt == 0) {
                    map.remove(x);
                } else {
                    map.put(x, cnt);
                }
            }
        }
        return ans;
    }*/
}
