package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 商品折扣后的最终价格
 *
 * @author byu_rself
 * @date 2022/9/1 9:52
 */
public class P1475 {

    @Test
    public void solution() {
        int[] prices = new int[]{8, 4, 6, 2, 3};
        int[] res = finalPrices(prices);
        for (int p : res) {
            System.out.print(p + " ");
        }
    }

    public int[] finalPrices(int[] prices) {
        int length = prices.length;
        int[] res = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = length - 1; i >= 0; i--) {
            // 如果栈顶元素大于当前价格，则没有折扣，弹出栈
            while (!stack.isEmpty() && stack.peek() > prices[i]) stack.pop();
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return res;
    }
}
