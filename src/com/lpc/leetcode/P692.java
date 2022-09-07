package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 前K个高频单词
 *
 * @author byu_rself
 * @date 2022/9/7 16:48
 */
public class P692 {

    @Test
    public void solution() {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> list = topKFrequent(words, k);
        list.forEach(System.out::println);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> q = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) return b.compareTo(a); // 字符频率出现相同，按字典序排序
            else return map.get(a) - map.get(b); // 字符频率出现不同，按频率排序
        });

        for (String s : map.keySet()) {
            q.offer(s);
            if (q.size() > k) q.poll();
        }

        List<String> list = new ArrayList<>();
        while (q.size() > 0) {
            list.add(q.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
