package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 滑动窗口的最大值
 *
 * @author byu_rself
 * @date 2022/8/29 13:22
 */
public class Offer059I {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        for (int n : ans) {
            System.out.print(n + "\t");
        }
    }

    /**
     * 队列按从大到小放入
     * 如果首位值（即最大值）不在窗口区间，删除首位
     * 如果新增的值小于队列尾部值，加到队列尾部
     * 如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
     * 如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            // 队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            // 一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            // 执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            deque.addLast(nums[i]);
        }
        // 窗口区间刚形成后，把队列首位值添加到队列中，此时为最大值
        ans[0] = deque.peekFirst();
        // 形成窗口后
        for (int i = k; i < length; i++) {
            // i-k是已经在区间外了，如果队首等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            if (deque.peekFirst() == nums[i - k]) deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            ans[i - k + 1] = deque.peekFirst();
        }
        return ans;
    }
}
