package com.lpc.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 吃苹果的最大数目
 *
 * @author byu_rself
 * @date 2022/9/7 16:37
 */
public class P1705 {

    @Test
    public void solution() {
        int[] apples = new int[]{1, 2, 3, 5, 2};
        int[] days = new int[]{3, 2, 1, 4, 2};
        System.out.println(eatenApples(apples, days));
    }

    public int eatenApples(int[] apples, int[] days) {
        // 以[最后食用日期, 当日产生的苹果数量]存储，按最后食用日期升序排列
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int ans = 0, time = 0, n = apples.length;
        while (time < n || !q.isEmpty()) {
            if (time < n && apples[time] > 0) q.add(new int[]{time + days[time] - 1, apples[time]});
            // 如果队列不为空且当前对顶的最后食用日期小于当前时间，即已过期，则删除
            while (!q.isEmpty() && q.peek()[0] < time) q.poll();
            if (!q.isEmpty()) {
                int[] cur = q.poll();
                // 如果对顶元素的最后食用日期大于当前时间并且在被食用一个苹果后仍有苹果剩余，则重新入队
                if (cur[0] > time && --cur[1] > 0) q.add(cur);
                ans++;
            }
            time++;
        }
        return ans;
    }
}
