package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 子数组的最小值之和
 *
 * @author byu_rself
 * @date 2022/9/15 12:15
 */
public class P907 {

    @Test
    public void solution() {
        int[] arr = new int[]{3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }

    private static final int MOD = (int) (1e9 + 7);

    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int right = 0; right <= n; ++right) {
            int x = right < n ? arr[right] : -1;
            while (stack.size() > 1 && arr[stack.peek()] >= x) {
                int i = stack.pop();
                ans += (long) arr[i] * (i - stack.peek()) * (right - i);
            }
            stack.push(right);
        }
        return (int) (ans % MOD);
    }

    /*public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; ++i) {
            // 左边界 left[i] 为左侧严格小于 arr[i] 的最近元素位置（不存在时为-1）
            while (stack.size() > 1 && arr[stack.peek()] >= arr[i]) {
                right[stack.pop()] = i; // 此时 i 恰好为栈顶的右边界
            }
            left[i] = stack.peek();
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i);
        }
        return (int) (ans % MOD);
    }*/

    /*public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n], right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; ++i) {
            // 左边界 left[i] 为左侧严格小于 arr[i] 的最近元素位置（不存在时为-1）
            while (stack.size() > 1 && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        stack.push(n);
        for (int i = n - 1; i >= 0; --i) {
            // 右边界 right[i] 为右侧小于等于 arr[i] 的最近元素位置（不存在时为n）
            while (stack.size() > 1 && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.peek();
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i);
        }
        return (int) (ans % MOD);
    }*/

    public int sumSubarrayMins3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        long ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = -1; i <= n; i++) {
            while (!stack.isEmpty() && getElement(arr, n, stack.peek()) > getElement(arr, n, i)) {
                int cur = stack.pop();
                int l = stack.peek(), r = i;
                ans = (ans + (long) (cur - l) * (r - cur) * arr[cur]) % MOD;
            }
            stack.push(i);
        }
        return (int) ans;
    }

    public int sumSubarrayMins2(int[] arr) {
        // 处理边界情况
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        long ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        // 将下标-1和n作为两个哨兵元素，它们对应的元素为MIN_VALUE，-1作为最左边界，n作为最右边界
        for (int i = -1; i <= n; i++) {
            // 向左寻找第一个小于等于A[i]的元素
            while (!stack.isEmpty() && getElement(arr, n, stack.peek()) > getElement(arr, n, i)) {
                // 对于每个出栈元素来说，i就是它们的右边界，而栈顶元素就是左边界
                int cur = stack.pop();
                // 计算贡献值
                ans = (ans + (long) (cur - stack.peek()) * (i - cur) * arr[cur]) % MOD;
            }
            stack.push(i);
        }
        return (int) ans;
    }

    private int getElement(int[] arr, int n, int i) {
        if (i == -1 || i == n) {
            return Integer.MIN_VALUE;
        }
        return arr[i];
    }

    public int sumSubarrayMins1(int[] arr) {
        // 处理边界情况
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        // 每个元素辐射范围的左边界
        int[] left = new int[n];
        // 每个元素辐射范围的右边界
        int[] right = new int[n];
        Deque<Integer> stack = new LinkedList<>();

        // 找到所有元素的左边界
        for (int i = 0; i < n; i++) {
            // 向左找第一个小于等于E的元素
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // 设立一个最左边界-1
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        // 找到所有元素的右边界
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 向右找第一个小于E的元素
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // 设立一个最右边界n
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) (i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int) ans;
    }
}
