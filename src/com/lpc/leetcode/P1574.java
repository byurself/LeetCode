package com.lpc.leetcode;

/**
 * 删除最短的子数组使剩余数组有序
 *
 * @author byu_rself
 * @date 2023/3/25 19:50
 */
public class P1574 {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) --right;
        if (right == 0) return 0; // arr已经是非递减数组
        int ans = right; // 此时arr[right-1] > arr[right], 删除 0 到 right-1
        for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; ++left) {
            while (right < n && arr[right] < arr[left]) ++right;
            ans = Math.min(ans, right - left - 1); // 此时 arr[left] <= arr[right]，从 left+1 到 right-1 可以删除
        }
        return ans;
    }
}
