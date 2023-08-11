package com.lpc.leetcode;

import java.util.*;

/**
 * O(1)时间插入、删除和获取随机元素
 *
 * @author byu_rself
 * @date 2023/8/11 14:32
 */
public class LCR030 {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public LCR030() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int size = list.size();
        int index = map.get(val);
        int lastVal = list.get(size - 1);
        map.put(lastVal, index);
        map.remove(val);
        list.set(index, lastVal);
        list.remove(size - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
