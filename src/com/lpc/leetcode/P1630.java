package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 等差子数组
 *
 * @author byu_rself
 * @date 2023/3/23 16:21
 */
public class P1630 {

    @Test
    public void solution() {
        int[] nums = new int[]{4, 6, 5, 9, 3, 7};
        int[] l = new int[]{0, 0, 2};
        int[] r = new int[]{2, 3, 5};
        System.out.println(checkArithmeticSubarrays(nums, l, r).toString());
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int left = l[i], right = r[i];
            int[] t = new int[right - left + 1];
            for (int j = left, k = 0; j <= right; ++j, ++k) {
                t[k] = nums[j];
            }
            int length = t.length;
            if (length <= 2) {
                ans.add(true);
                continue;
            }
            Arrays.sort(t);
            int d = t[1] - t[0];
            boolean flag = true;
            for (int j = 2; j < length; ++j) {
                int s = t[j] - t[j - 1];
                if (s != d) {
                    ans.add(false);
                    flag = false;
                    break;
                }
            }
            if (flag) ans.add(true);
        }
        return ans;
    }
}
