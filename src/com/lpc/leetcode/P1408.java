package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中的字符串匹配
 *
 * @author byu_rself
 * @date 2022/8/6 10:25
 */
public class P1408 {

    @Test
    public void solution() {
        String[] words = new String[]{"leetcode", "et", "code"};
        List<String> list = stringMatching1(words);
        list.forEach(System.out::println);
    }

    public List<String> stringMatching1(String[] words) {
        List<String> list = Arrays.stream(words).toList();
        return list.stream().filter(k -> list.stream().filter(v -> v.contains(k)).count() > 1).toList();
    }

    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
