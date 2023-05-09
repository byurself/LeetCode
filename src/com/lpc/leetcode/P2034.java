package com.lpc.leetcode;

import java.util.*;

/**
 * 股票价格波动
 *
 * @author byu_rself
 * @date 2022/9/5 1:02
 */
public class P2034 {

    int cur;
    Map<Integer, Integer> timePriceMap; // key: timestamp   value: price
    TreeMap<Integer, Integer> priceTimeCntMap; // key: price   value: 时间戳数量

    public P2034() {
        cur = 0;
        timePriceMap = new HashMap<>();
        priceTimeCntMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timePriceMap.containsKey(timestamp)) {
            Integer oldPrice = timePriceMap.get(timestamp);
            int cnt = priceTimeCntMap.get(oldPrice);
            if (cnt == 1) priceTimeCntMap.remove(oldPrice);
            else priceTimeCntMap.put(oldPrice, cnt - 1);
        }
        timePriceMap.put(timestamp, price);
        priceTimeCntMap.merge(price, 1, Integer::sum);
        cur = Math.max(cur, timestamp);
    }

    public int current() {
        return timePriceMap.get(cur);
    }

    public int maximum() {
        return priceTimeCntMap.lastKey();
    }

    public int minimum() {
        return priceTimeCntMap.firstKey();
    }

/*    private int maxTimeStamp;
    private Map<Integer, Integer> timePriceMap; // key:时间戳 value: 价格
    private TreeMap<Integer, Integer> priceMap; // key:价格 value: 时间戳数量

    public P2034() {
        maxTimeStamp = 0;
        timePriceMap = new HashMap<>();
        priceMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        // timestamp已经有记录，需要更新
        if (timePriceMap.containsKey(timestamp)) {
            Integer oldPrice = timePriceMap.get(timestamp);
            Integer cnt = priceMap.get(oldPrice);
            if (cnt == 1) priceMap.remove(oldPrice);
            else priceMap.put(oldPrice, cnt - 1);
        }
        timePriceMap.put(timestamp, price);
        priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
        maxTimeStamp = Math.max(maxTimeStamp, timestamp);
    }

    public int current() {
        return timePriceMap.get(maxTimeStamp);
    }

    public int maximum() {
        return priceMap.lastKey();
    }

    public int minimum() {
        return priceMap.firstKey();
    }*/
}
