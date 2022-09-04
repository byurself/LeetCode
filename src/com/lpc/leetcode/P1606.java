package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 找到处理最多请求的服务器
 *
 * @author byu_rself
 * @date 2022/9/5 0:38
 */
public class P1606 {

    @Test
    public void solution() {
        int k = 3;
        int[] arrival = new int[]{1, 2, 3, 4, 5};
        int[] load = new int[]{5, 2, 3, 3, 3};
        List<Integer> list = busiestServers(k, arrival, load);
        list.forEach(System.out::println);
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // 空闲服务器集合
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        // 正在处理请求的服务器
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        // 服务器处理的请求数目
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            // 如果busy不空且队首对应的服务器的结束时间小于当前请求到达的时间，则将它从busy中移除，并加入空闲集合中
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }
            // 如果没有服务器空闲，则舍弃该请求
            if (available.isEmpty()) {
                continue;
            }
            Integer p = available.ceiling(i % k);
            if (p == null) {
                p = available.first();
            }
            requests[p]++;
            busy.offer(new int[]{arrival[i] + load[i], p});
            available.remove(p);
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                res.add(i);
            }
        }
        return res;
    }
}
