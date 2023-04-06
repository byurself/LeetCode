package com.lpc.leetcode;

import java.util.*;

/**
 * 单词接龙
 *
 * @author byu_rself
 * @date 2023/4/3 13:37
 */
public class P127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        Deque<String> queue1 = new ArrayDeque<>();
        Deque<String> queue2 = new ArrayDeque<>();
        visited1.add(beginWord);
        visited2.add(endWord);
        queue1.offer(beginWord);
        queue2.offer(endWord);
        int ans = 1;
        Set<String> wordSet = new HashSet<>(wordList);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            ++ans;
            if (queue1.size() > queue2.size()) {
                Set<String> temp = visited1;
                visited1 = visited2;
                visited2 = temp;
                Deque<String> t = queue1;
                queue1 = queue2;
                queue2 = t;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String cur = queue1.poll();
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; ++i) {
                    char c0 = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String s = new String(chars);
                        if (visited1.contains(s)) continue;
                        if (visited2.contains(s)) return ans;
                        if (wordSet.contains(s)) {
                            queue1.offer(s);
                            visited1.add(s);
                        }
                    }
                    chars[i] = c0;
                }
            }
        }
        return 0;
    }

    private boolean canConvert(String start, String end) {
        int cnt = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) != end.charAt(i)) ++cnt;
            if (cnt > 1) return false;
        }
        return true;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int index = wordList.indexOf(endWord);
        if (index == -1) return 0;

        wordList.add(beginWord);
        Deque<String> queue1 = new ArrayDeque<>();
        Deque<String> queue2 = new ArrayDeque<>();
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);

        int ans = 1;
        Set<String> wordSet = new HashSet<>(wordList);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            ++ans;
            // 从节点更少的一端开始遍历
            if (queue1.size() > queue2.size()) {
                Deque<String> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = queue1.poll();
                char[] chars = s.toCharArray();
                for (int i = 0; i < s.length(); ++i) {
                    // 保存第i位的原始字符
                    char c0 = chars[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String newString = new String(chars);
                        if (visited1.contains(newString)) continue; // 已经访问过了，跳过
                        if (visited2.contains(newString)) return ans; // 两端遍历相遇，结束遍历，返回 count
                        // 如果单词在列表中存在，将其添加到队列，并标记为已访问
                        if (wordSet.contains(newString)) {
                            queue1.offer(newString);
                            visited1.add(newString);
                        }
                    }
                    // 恢复第i位的原始字符
                    chars[i] = c0;
                }
            }
        }
        return 0;
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        // Set<String> visited = new HashSet<>();
        boolean[] visited = new boolean[wordList.size()];
        int index = wordList.indexOf(beginWord);
        if (index != -1) visited[index] = true;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++ans;
            for (int i = 0; i < size; ++i) {
                String start = queue.poll();
                for (int j = 0; j < wordList.size(); ++j) {
                    if (visited[j]) continue; // 已经访问过，跳过
                    String s = wordList.get(j);
                    if (!canConvert(start, s)) continue; // 不能转换，跳过
                    if (s.equals(endWord)) return ans;
                    visited[j] = true;
                    queue.offer(s);
                }
                // for (String s : wordList) {
                //     if (visited.contains(s)) continue; // 已经访问过，跳过
                //     if (!canConvert(start, s)) continue; // 不能转换，跳过
                //     if (s.equals(endWord)) return ans;
                //     visited.add(s);
                //     queue.offer(s);
                // }
            }
        }
        return 0;
    }
}
