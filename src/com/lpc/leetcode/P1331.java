package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组序号转换
 *
 * @author byu_rself
 * @date 2022/7/28 10:40
 */
public class P1331 {

    @Test
    public void solution() {
        int[] arr = new int[]{40, 10, 20, 30};
        int[] result = arrayRankTransform(arr);
        for (int n : result) {
            System.out.print(n + "\t");
        }
    }

    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0, length = arr.length;
        for (int n : clone) {
            if (!map.containsKey(n)) {
                map.put(n, ++index);
            }
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}
