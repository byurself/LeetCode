package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 最近的请求次数
 *
 * @author byu_rself
 * @date 2022/5/6 14:13
 */
public class P933 {

    @Test
    public void solution() {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(recentCounter.ping(100));   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }

    static class RecentCounter {

        Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.offer(t);
            // 当队首元素小于当前请求时间-3000ms，则在队列中删除该元素
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            // 最后队列的所剩的元素个数
            return queue.size();
        }
    }
}
