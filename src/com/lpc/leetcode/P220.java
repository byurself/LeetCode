package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 存在重复元素III
 *
 * @author byu_rself
 * @date 2023/8/18 11:11
 */
public class P220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        long size = t + 1L;
        for (int i = 0; i < n; ++i) {
            long u = nums[i];
            long idx = getIdx(u, size);
            // 目标桶已存在（桶不为空），说明前面已有 [u - t, u + t] 范围的数字
            if (map.containsKey(idx)) return true;
            // 检查相邻的桶
            long l = idx - 1, r = idx + 1;
            if (map.containsKey(l) && u - map.get(l) <= t) return true;
            if (map.containsKey(r) && map.get(r) - u <= t) return true;
            // 建立目标桶
            map.put(idx, u);
            // 移除下标范围不在 [max(0, i - k), i) 内的桶
            if (i >= k) map.remove(getIdx(nums[i - k], size));
        }
        return false;
    }

    private long getIdx(long u, long size) {
        return u >= 0 ? u / size : ((u + 1) / size) - 1;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // 大于等于所给元素的最小值
            Long u = treeSet.ceiling((long) nums[i] - (long) valueDiff);
            if (u != null && u <= (long) nums[i] + (long) valueDiff) return true;
            treeSet.add((long) nums[i]);
            if (i >= indexDiff) treeSet.remove((long) nums[i - indexDiff]);
        }
        return false;
    }
}
