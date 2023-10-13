package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 元素和为目标值的子矩阵数量
 *
 * @author byu_rself
 * @date 2023/10/13 11:04
 */
public class P1074 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        // 枚举上边界
        for (int i = 0; i < m; ++i) {
            int[] sum = new int[n];
            // 枚举下边界
            for (int j = i; j < m; ++j) {
                for (int k = 0; k < n; ++k) {
                    // 更新每列的元素和
                    sum[k] += matrix[j][k];
                }
                ans += subarraySum(sum, target);
            }
        }
        return ans;
    }

    // LC.P569[和为K的子数组]
    public int subarraySum(int[] nums, int k) {
        int pre = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.merge(pre, 1, Integer::sum);
        }
        return ans;
    }
}
