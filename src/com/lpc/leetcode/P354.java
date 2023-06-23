package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 俄罗斯套娃信封问题
 *
 * @author byu_rself
 * @date 2023/6/23 14:36
 */
public class P354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // 按宽度升序
            else return b[1] - a[1]; // 按高度降序
        });

        List<Integer> f = new ArrayList<>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int h = envelopes[i][1];
            if (h > f.get(f.size() - 1)) {
                f.add(h);
            } else {
                int index = binarySearch(f, h);
                f.set(index, h);
            }
        }
        return f.size();
    }

    private int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = low + high >> 1;
            if (f.get(mid) >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
