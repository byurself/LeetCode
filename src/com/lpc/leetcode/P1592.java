package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 重新排列单词间的空格
 *
 * @author byu_rself
 * @date 2022/9/7 15:32
 */
public class P1592 {

    @Test
    public void solution() {
        String text = "   a";
        System.out.println(reorderSpaces(text));
    }

    public String reorderSpaces(String text) {
        int length = text.length(), cnt = 0;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < length; ) {
            char c = text.charAt(i);
            if (c == ' ') {
                cnt++;
                i++;
            } else {
                int j = i;
                while (j < length && text.charAt(j) != ' ') j++;
                list.add(text.substring(i, j));
                i = j;
            }
        }
        int size = list.size(), index = 0;
        StringBuilder builder = new StringBuilder();
        if (size == 1) {
            builder.append(list.get(0)).append(" ".repeat(cnt));
        } else {
            for (String s : list) {
                if (index++ == 0) builder.append(s);
                else builder.append(" ".repeat(cnt / (size - 1))).append(s);
            }
            builder.append(" ".repeat(cnt % (size - 1)));
        }
        return builder.toString();
    }
}
