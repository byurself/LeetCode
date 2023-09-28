package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 花期内花的数目
 *
 * @author byu_rself
 * @date 2023/9/28 9:13
 */
public class P2251 {

    @Test
    public void solution() {
        int[][] flowers = new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}};
        int[] people = new int[]{2, 3, 7, 11};
        System.out.println(Arrays.toString(fullBloomFlowers(flowers, people)));
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (int[] flower : flowers) {
            d.merge(flower[0], 1, Integer::sum);
            d.merge(flower[1] + 1, -1, Integer::sum);
        }
        int sum = 0, m = people.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> people[a] - people[b]);
        int[] ans = new int[m];
        for (int i : idx) {
            int p = people[i];
            while (!d.isEmpty() && d.firstKey() <= p) {
                sum += d.pollFirstEntry().getValue();
            }
            ans[i] = sum;
        }
        return ans;
    }

    public int[] fullBloomFlowers1(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; ++i) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 0; i < people.length; ++i) {
            people[i] = binarySearch(starts, people[i] + 1) - binarySearch(ends, people[i]);
        }
        return people;
    }

    private int binarySearch(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + right >>> 1;
            if (nums[mid] >= x) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}
