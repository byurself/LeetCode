package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 保证文件名唯一
 *
 * @author byu_rself
 * @date 2023/3/3 10:01
 */
public class P1487 {

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        int n = names.length;
        for (int i = 0; i < n; ++i) {
            if (map.containsKey(names[i])) {
                int cnt = map.get(names[i]);
                while (map.containsKey(names[i] + "(" + cnt + ")")) {
                    ++cnt;
                }
                map.put(names[i], cnt);
                names[i] += "(" + cnt + ")";
            }
            map.put(names[i], 1);
        }
        return names;
    }
}
