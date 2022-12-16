package com.lpc.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统计匹配检索规则的物品数量
 *
 * @author byu_rself
 * @date 2022/10/29 12:20
 */
public class P1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> map = new HashMap<>() {
            {
                put("type", 0);
                put("color", 1);
                put("name", 2);
            }
        };
        int index = map.get(ruleKey), ans = 0;
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) ans++;
        }
        return ans;
    }
}
