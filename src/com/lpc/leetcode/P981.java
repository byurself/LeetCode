package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 基于时间的键值存储
 *
 * @author byu_rself
 * @date 2022/9/3 19:24
 */
public class P981 {

    @Test
    public void solution() {
        get("2", 1);
    }

    Map<String, TreeMap<Integer, String>> map;

    public P981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        map.put(key, treeMap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        // floorEntry: 返回与小于或等于给定键的最大键相关联的键值映射，如果没有则返回null
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        // 如果entry为空，返回""
        return entry == null ? "" : entry.getValue();
    }
}
