package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 子域名访问计数
 *
 * @author byu_rself
 * @date 2022/10/5 0:20
 */
public class P811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int index = cpdomain.indexOf(' ');
            int cnt = Integer.parseInt(cpdomain.substring(0, index));
            String domain = cpdomain.substring(index + 1);
            map.put(domain, map.getOrDefault(domain, 0) + cnt);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subDomain = domain.substring(i + 1);
                    map.put(subDomain, map.getOrDefault(subDomain, 0) + cnt);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }
}
