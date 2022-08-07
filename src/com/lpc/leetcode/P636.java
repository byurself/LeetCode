package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 函数的独占时间
 *
 * @author byu_rself
 * @date 2022/8/7 10:57
 */
public class P636 {

    @Test
    public void solution() {
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        int[] ans = exclusiveTime(n, logs);
        for (int res : ans) {
            System.out.println(res);
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int last = -1;
        for (String log : logs) {
            String[] ss = log.split(":");
            int index = Integer.parseInt(ss[0]), ts = Integer.parseInt(ss[2]);
            if (ss[1].equals("start")) {
                if (!stack.isEmpty()) ans[stack.peekLast()] += ts - last;
                stack.addLast(index);
                last = ts;
            } else {
                int cur = stack.pollLast();
                ans[cur] += ts - last + 1;
                last = ts + 1;
            }
        }
        return ans;
    }
}
