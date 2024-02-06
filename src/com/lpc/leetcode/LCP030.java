package com.lpc.leetcode;

import java.util.PriorityQueue;

/**
 * 魔塔游戏
 *
 * @author byu_rself
 * @date 2024/2/6 10:13
 */
public class LCP030 {

    public int magicTower(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) {
            return -1;
        }
        int ans = 0;
        long hp = 1;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            if (num < 0) {
                q.offer(num);
            }
            hp += num;
            if (hp < 1) {
                // 这意味着 num < 0，前面必然会把 num 入堆
                // 所以堆必然不是空的，并且堆顶 <= num
                hp -= q.poll();
                ++ans;
            }
        }
        return ans;
    }
}
