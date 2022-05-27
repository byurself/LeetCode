package com.lpc.leetcode;

import org.junit.Test;

/**
 * Find Closest LCCI
 *
 * @author byu_rself
 * @date 2022/5/27 19:42
 */
public class Interview1711 {

    @Test
    public void solution() {
        String[] words = new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        String word1 = "a";
        String word2 = "student";
        System.out.println(findClosest(words, word1, word2));
    }

    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int result = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                result = Math.min(Math.abs(index1 - index2), result);
            }
        }
        return result;
    }
}
