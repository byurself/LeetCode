package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 下一个更大元素 I
 *
 * @author byu_rself
 * @date 2022/9/10 1:03
 */
public class P496 {

    @Test
    public void solution() {
        int[] nums1 = new int[]{4, 1, 2}, nums2 = new int[]{1, 3, 4, 2};
        int[] ans = nextGreaterElement(nums1, nums2);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[n];
        for (int i = m - 1; i >= 0; --i) {
            int cur = nums2[i];
            while (!stack.isEmpty() && cur >= stack.peek()) stack.pop();
            map.put(cur, stack.isEmpty() ? -1 : stack.peek());
            stack.push(cur);
        }
        for (int i = 0; i < n; ++i) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int j = 0;
            while (j < m && nums1[i] != nums2[j]) ++j;
            while (j < m && nums1[i] >= nums2[j]) ++j;
            ans[i] = j < m ? nums2[j] : -1;
        }
        return ans;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num > stack.peek()) stack.pop();
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n && nums1[i] != nums2[j]) j++;
            while (j < n && nums1[i] >= nums2[j]) j++;
            ans[i] = j < n ? nums2[j] : -1;
        }
        return ans;
    }
}
