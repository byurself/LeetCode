package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 按照频率将数组升序排序
 *
 * @author byu_rself
 * @date 2022/9/19 14:18
 */
public class P1636 {

    @Test
    public void solution() {
        int[] nums = new int[]{2, 3, 1, 3, 2};
        int[] ans = frequencySort(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1).equals(map.get(o2))) return o2 - o1;
                else return map.get(o1) - map.get(o2);
            }
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
