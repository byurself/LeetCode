package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 大样本统计
 *
 * @author byu_rself
 * @date 2023/5/27 16:41
 */
public class P1093 {

    @Test
    public void solution() {
        int[] count = new int[]{0, 4, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(sampleStats(count)));
    }

    int[] count;

    public double[] sampleStats(int[] count) {
        this.count = count;
        int minimum = Integer.MAX_VALUE, maximum = -1, cnt = 0, mode = 0;
        double sum = 0;
        for (int i = 0; i < count.length; ++i) {
            if (count[i] > 0) {
                minimum = Math.min(minimum, i);
                maximum = Math.max(maximum, i);
                cnt += count[i];
                sum += (double) i * count[i];
                if (count[i] > count[mode]) mode = i;
            }
        }
        double median = cnt % 2 == 1 ? find(cnt / 2 + 1) : (find(cnt / 2 + 1) + find(cnt / 2)) / 2.0;
        return new double[]{minimum, maximum, sum / cnt, median, mode};
    }

    private int find(int i) {
        for (int k = 0, t = 0; ; ++k) {
            t += count[k];
            if (t >= i) return k;
        }
    }
}
