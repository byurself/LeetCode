package com.lpc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 美丽塔II
 *
 * @author byu_rself
 * @date 2023/12/21 9:26
 */
public class P2866 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        for (int i = 0; i < n; ++i) {
            int x = maxHeights.get(i);
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > x) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            int x = maxHeights.get(i);
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) >= x) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        long[] f = new long[n], g = new long[n];
        for (int i = 0; i < n; ++i) {
            int x = maxHeights.get(i);
            if (i > 0 && x >= maxHeights.get(i - 1)) {
                f[i] = f[i - 1] + x;
            } else {
                int j = left[i];
                f[i] = (long) x * (i - j) + (j >= 0 ? f[j] : 0);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            int x = maxHeights.get(i);
            if (i < n - 1 && x >= maxHeights.get(i + 1)) {
                g[i] = g[i + 1] + x;
            } else {
                int j = right[i];
                g[i] = (long) x * (j - i) + (j < n ? g[j] : 0);
            }
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, f[i] + g[i] - maxHeights.get(i));
        }
        return ans;
    }
}
