package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 餐厅过滤器
 *
 * @author byu_rself
 * @date 2023/9/27 9:37
 */
public class P1333 {

    @Test
    public void solution() {
        int[][] restaurants = new int[][]{
                {1, 4, 1, 40, 10},
                {2, 8, 0, 50, 5},
                {3, 8, 1, 30, 4},
                {4, 10, 0, 10, 3},
                {5, 1, 1, 15, 1}
        };
        int vegenFriendly = 1, maxPrice = 50, maxDistance = 10;
        List<Integer> ans = filterRestaurants(restaurants, vegenFriendly, maxPrice, maxDistance);
        ans.forEach(System.out::println);
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(r -> veganFriendly == 0 || r[2] == veganFriendly)
                .filter(r -> r[3] <= maxPrice)
                .filter(r -> r[4] <= maxDistance)
                .sorted((a, b) -> {
                    if (a[1] != b[1]) return b[1] - a[1];
                    else return b[0] - a[0];
                })
                .map(r -> r[0])
                .collect(Collectors.toList());
    }

    public List<Integer> filterRestaurants1(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> ans = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        for (int[] r : restaurants) {
            if (veganFriendly == 1 && r[2] == 0) continue;
            if (r[3] > maxPrice) continue;
            if (r[4] > maxDistance) continue;
            list.add(r);
        }
        list.sort((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            else return b[0] - a[0];
        });
        for (int[] a : list) {
            ans.add(a[0]);
        }
        return ans;
    }
}
