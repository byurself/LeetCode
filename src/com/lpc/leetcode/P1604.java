package com.lpc.leetcode;

import java.util.*;

/**
 * 警告一小时内使用相同员工卡大于等于三次的人
 *
 * @author byu_rself
 * @date 2023/2/7 13:42
 */
public class P1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            map.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            map.get(name).add(hour * 60 + minute);
        }
        for (String name : map.keySet()) {
            List<Integer> list = map.get(name);
            list.sort((a, b) -> a - b);
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 2) <= 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
