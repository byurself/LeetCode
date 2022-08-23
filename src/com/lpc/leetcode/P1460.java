package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过翻转子数组使两个数组相等
 *
 * @author byu_rself
 * @date 2022/8/24 0:33
 */
public class P1460 {

    @Test
    public void solution() {
        int[] target = new int[]{1, 2, 3, 4};
        int[] arr = new int[]{2, 4, 1, 3};
        System.out.println(canBeEqual(target, arr));
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    public boolean canBeEqual1(int[] target, int[] arr) {
        int length = target.length;
        Map<Integer, Integer> targetMap = new HashMap<>();
        Map<Integer, Integer> arrMap = new HashMap<>();
        boolean res = true;
        for (int i = 0; i < length; i++) {
            targetMap.put(target[i], targetMap.getOrDefault(target[i], 0) + 1);
            arrMap.put(arr[i], arrMap.getOrDefault(arr[i], 0) + 1);
        }

        for (int n : target) {
            if (!targetMap.get(n).equals(arrMap.get(n))) res = false;
        }
        return res;
    }
}
