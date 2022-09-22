package com.lpc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 能否连接形成数组
 *
 * @author byu_rself
 * @date 2022/7/27 14:49
 */
public class P1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length, m = pieces.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(pieces[i][0], i);
        }
        int i = 0;
        while (i < n) {
            if (!map.containsKey(arr[i])) return false;
            int j = map.get(arr[i]);
            for (int k = 0; k < pieces[j].length; k++) {
                if (arr[i + k] != pieces[j][k]) return false;
            }
            i += pieces[j].length;
        }
        return true;
    }

    public boolean canFormArray1(int[] arr, int[][] pieces) {
        int[] map = new int[101];
        Arrays.fill(map, -1);
        for (int i = 0; i < pieces.length; i++) {
            map[pieces[i][0]] = i;
        }
        int i = 0;
        while (i < arr.length) {
            int pieceIndex = map[arr[i]];
            if (pieceIndex != -1) {
                int[] piece = pieces[pieceIndex];
                ++i;
                for (int j = 1; j < piece.length; j++) {
                    if (arr[i] != piece[j]) {
                        return false;
                    } else {
                        ++i;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
