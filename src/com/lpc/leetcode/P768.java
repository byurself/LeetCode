package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最多能完成排序的块II
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
        for (int x : arr) {
            if (!stack.isEmpty() && x < stack.peek()) {
                int max = stack.poll();
                while (!stack.isEmpty() && x < stack.peek()) stack.poll();
                stack.push(max);
            } else {
                stack.push(x);
            }
        }
        return stack.size();
    }
}
