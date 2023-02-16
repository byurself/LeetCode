package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组能形成多少数对
 *
 * @author byu_rself
 * @date 2023/2/16 18:13
 */
public class P2341 {

    @Test
    public void solution() {
        int[] nums = new int[]{1, 3, 2, 1, 3, 2, 2};
        System.out.println(Arrays.toString(numberOfPairs(nums)));
    }

    public int[] numberOfPairs(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2], cnt = new int[100];
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 0; i < 100; i++) {
            ans[0] += cnt[i] / 2;
        }
        ans[1] = n - ans[0] * 2;
        return ans;
    }

    public int[] numberOfPairs1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                nums[map.get(nums[i])] = -1;
                map.remove(nums[i]);
                nums[i] = -1;
                ans[0]++;
            } else {
                map.put(nums[i], i);
            }
        }
        for (int num : nums) {
            if (num != -1) ans[1]++;
        }
        return ans;
    }
}
