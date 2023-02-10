package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 森林中的兔子
 *
 * @author byu_rself
 * @date 2023/2/10 16:23
 */
public class P781 {

    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int ans = 0, n = answers.length;
        for (int i = 0; i < n; i++) {
            int cnt = answers[i];
            ans += cnt + 1;
            while (cnt-- > 0 && i + 1 < n && answers[i] == answers[i + 1]) i++;
        }
        return ans;
    }
}
