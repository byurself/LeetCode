package com.lpc.leetcode;

import java.util.*;

/**
 * 子数组中占绝大多数的元素
 *
 * @author byu_rself
 * @date 2023/4/16 14:37
 */
public class P1157 {

    static final int K = 20;
    int[] arr;
    Map<Integer, List<Integer>> loc;
    Random random;

    public P1157(int[] arr) {
        this.arr = arr;
        this.loc = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            loc.putIfAbsent(arr[i], new ArrayList<>());
            loc.get(arr[i]).add(i);
        }
        this.random = new Random();
    }

    public int query(int left, int right, int threshold) {
        int length = right - left + 1;
        for (int i = 0; i < K; ++i) {
            int x = arr[left + random.nextInt(length)];
            List<Integer> pos = loc.get(x);
            int cnt = searchEnd(pos, right) - searchStart(pos, left);
            if (cnt >= threshold) {
                return x;
            } else if (cnt * 2 >= length) {
                return -1;
            }
        }
        return -1;
    }

    private int searchStart(List<Integer> pos, int target) {
        int low = 0, high = pos.size();
        while (low < high) {
            int mid = low + (high - low) >> 1;
            if (pos.get(mid) >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private int searchEnd(List<Integer> pos, int target) {
        int low = 0, high = pos.size();
        while (low < high) {
            int mid = low + (high - low) >> 1;
            if (pos.get(mid) > target) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
