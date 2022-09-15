package com.lpc.leetcode;

import org.junit.Test;

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

    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
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
