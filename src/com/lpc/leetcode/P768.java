package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最多能完成排序的块 II
 *
 * @author byu_rself
 * @date 2022/8/13 10:23
 */
public class P768 {

    @Test
    public void solution() {
        int[] arr = new int[]{1, 1, 2, 1, 1, 3, 4, 5, 1, 6};
        System.out.println(maxChunksToSorted(arr));
    }

    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int n : arr) {
            // 栈非空且当前遍历到的n小于栈顶元素，则需要合成一个排序块进行排序
            if (!stack.isEmpty() && n < stack.peekFirst()) {
                int max = stack.poll();
                while (!stack.isEmpty() && n < stack.peekFirst()) stack.pollFirst();
                stack.push(max);
            } else stack.push(n);
        }
        return stack.size();
    }
}
