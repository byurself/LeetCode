package com.lpc.leetcode;

import org.junit.Test;

/**
 * 最大交换
 *
 * @author byu_rself
 * @date 2022/9/13 13:52
 */
public class P670 {

    @Test
    public void solution() {
        int num = 2736;
        System.out.println(maximumSwap(num));
    }

    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int n = nums.length, maxIndex = n - 1, p = -1, q = 0;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            } else if (nums[i] < nums[maxIndex]) {
                p = i;
                q = maxIndex;
            }
        }
        // num 本身是降序
        if (p == -1) {
            return num;
        }
        char temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
        return Integer.parseInt(new String(nums));
    }

    public int maximumSwap1(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int maxIndex = i;
            // 从后往前选择一个最大的，这个最大的离i越远越好，比如1993，1交换第二个9更优，所以j倒序遍历
            for (int j = n - 1; j >= i + 1; --j) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                char temp = nums[maxIndex];
                nums[maxIndex] = nums[i];
                nums[i] = temp;
                return Integer.parseInt(new String(nums));
            }
        }
        return num;
    }
}
