package com.lpc.leetcode;

import org.junit.Test;

/**
 * 山脉数组的峰顶索引
 *
 * @author byu_rself
 * @date 2022/8/11 10:17
 */
public class p852 {

    @Test
    public void solution() {
        int[] arr = new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println(peakIndexInMountainArray3(arr));
    }

    /**
     * 二分
     */
    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 2;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] > arr[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    /**
     * 三分
     */
    public int peakIndexInMountainArray3(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m1 = l + (r - l) / 3, m2 = r - (r - l) / 3;
            if (arr[m1] > arr[m2]) r = m2 - 1; // 峰顶元素不可能在[m2,r]中
            else l = m1 + 1;
        }
        return r;
    }
}
