package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Falling Squares
 *
 * @author byu_rself
 * @date 2022/5/26 11:54
 */
public class P699 {

    @Test
    public void solution() {
        int[][] positions = new int[][]{{1,2},{2,3},{6,1}};
        List<Integer> list = fallingSquares(positions);
        list.forEach(System.out::println);
    }

    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ret = new ArrayList<Integer>();
        TreeMap<Integer, Integer> heightMap = new TreeMap<Integer, Integer>();
        heightMap.put(0, 0); // 初始时从 0 开始的所有点的堆叠高度都是 0
        for (int i = 0; i < n; i++) {
            int size = positions[i][1];
            int left = positions[i][0], right = positions[i][0] + positions[i][1] - 1;
            Integer lp = heightMap.higherKey(left), rp = heightMap.higherKey(right);
            Integer prevRightKey = rp != null ? heightMap.lowerKey(rp) : heightMap.lastKey();
            int rHeight = prevRightKey != null ? heightMap.get(prevRightKey) : 0; // 记录 right + 1 对应的堆叠高度（如果 right + 1 不在 heightMap 中）

            // 更新第 i 个掉落的方块的堆叠高度
            int height = 0;
            Integer prevLeftKey = lp != null ? heightMap.lowerKey(lp) : heightMap.lastKey();
            Map<Integer, Integer> tail = prevLeftKey != null ? heightMap.tailMap(prevLeftKey) : heightMap;
            for (Map.Entry<Integer, Integer> entry : tail.entrySet()) {
                if (entry.getKey() == rp) {
                    break;
                }
                height = Math.max(height, entry.getValue() + size);
            }

            // 清除 heightMap 中位于 (left, right] 内的点
            Set<Integer> keySet = new TreeSet<Integer>(tail.keySet());
            for (Integer tmp : keySet) {
                if (lp == null || tmp < lp) {
                    continue;
                }
                if (rp != null && tmp >= rp) {
                    break;
                }
                heightMap.remove(tmp);
            }

            heightMap.put(left, height); // 更新 left 的变化
            if (rp == null || rp != right + 1) { // 如果 right + 1 不在 heightMap 中，更新 right + 1 的变化
                heightMap.put(right + 1, rHeight);
            }
            ret.add(i > 0 ? Math.max(ret.get(i - 1), height) : height);
        }
        return ret;
    }
}
