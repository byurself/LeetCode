package com.lpc.leetcode;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素
 *
 * @author byu_rself
 * @date 2022/9/18 4:04
 */
public class P380 {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public P380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int size = list.size();
        Integer lastVal = list.get(size - 1);
        Integer index = map.get(val);
        list.set(index, lastVal);
        map.put(lastVal, index);
        map.remove(val);
        list.remove(size - 1);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
