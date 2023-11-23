package com.lpc.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * HTML实体解析器
 *
 * @author byu_rself
 * @date 2023/11/23 9:02
 */
public class P1410 {

    @Test
    public void solution() {
        String s = "&&&";
        System.out.println(entityParser(s));
    }

    private static final Map<String, String> map = new HashMap<>() {{
        put("&quot;", "\"");
        put("&apos;", "'");
        put("&amp;", "&");
        put("&gt;", ">");
        put("&lt;", "<");
        put("&frasl;", "/");
    }};

    public String entityParser(String text) {
        StringBuilder builder = new StringBuilder();
        int n = text.length();
        for (int i = 0; i < n; ++i) {
            char c = text.charAt(i);
            if (c == '&') {
                int j = i + 1;
                boolean flag = false;
                for (; j < n && text.charAt(j) != ';'; ++j) {
                    if (text.charAt(j) == '&') {
                        builder.append(text, i, j);
                        i = j - 1;
                        flag = true;
                        break;
                    }
                }
                if (flag) continue;
                String s = text.substring(i, j == n ? n : j + 1);
                i = j;
                s = map.getOrDefault(s, s);
                builder.append(s);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
