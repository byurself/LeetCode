package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户分组
 *
 * @author byu_rself
 * @date 2022/8/12 12:10
 */
public class P1282 {

    @Test
    public void solution() {
        int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> lists = groupThePeople(groupSizes);
        for (List<Integer> list : lists) {
            for (Integer n : list) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int x = groupSizes[i];
            if (map.get(x) == null) map.put(x, new ArrayList<>());
            map.get(x).add(i);
            if (map.get(x).size() == x) {
                ans.add(map.get(x));
                map.put(x, null);
            }
        }
        return ans;
    }

    public List<List<Integer>> groupThePeople1(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            List<Integer> curList = new ArrayList<>();
            for (Integer p : list) {
                curList.add(p);
                if (curList.size() == key) {
                    ans.add(curList);
                    curList = new ArrayList<>();
                }
            }
        }
        return ans;
    }
}
