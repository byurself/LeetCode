package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 使数组严格递增
 *
 * @author byu_rself
 * @date 2023/4/20 19:11
 */
public class P1187 {
    int[] a, b;
    Map<Integer, Integer>[] cache;

    public int makeArrayIncreasing(int[] a, int[] b) {
        this.a = a;
        this.b = b;
        Arrays.sort(b);
        int n = a.length;
        cache = new HashMap[n];
        Arrays.setAll(cache, e -> new HashMap<>());
        int ans = dfs(n - 1, Integer.MAX_VALUE);
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    private int dfs(int i, int pre) {
        if (i < 0) return 0;
        if (cache[i].containsKey(pre)) return cache[i].get(pre);
        // 不替换
        int res = a[i] < pre ? dfs(i - 1, a[i]) : Integer.MAX_VALUE / 2;

        int k = lowerBound(b, pre) - 1;
        if (k >= 0) res = Math.min(res, dfs(i - 1, b[k]) + 1);
        cache[i].put(pre, res);
        return res;
    }

    private int lowerBound(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) left = mid;
            else right = mid;
        }
        return right;
    }
}
