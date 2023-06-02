package com.lpc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 单字符重复子串的最大长度
 *
 * @author byu_rself
 * @date 2023/6/3 0:11
 */
public class P1156 {

    public int maxRepOpt1(String text) {
        Map<Character, Integer> map = new HashMap<>();
        int n = text.length();
        // 统计各字符出现的次数
        for (int i = 0; i < n; ++i) {
            char c = text.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        int ans = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && text.charAt(j) == text.charAt(i)) ++j;
            int curCnt = j - i;

            // 如果这一段长度小于该字符出现的总数，并且前面或后面有空位，则使用 curCnt + 1 更新答案
            if (curCnt < map.getOrDefault(text.charAt(i), 0) && (j < n || i > 0)) {
                ans = Math.max(ans, curCnt + 1);
            }

            // 找到这一段后面与之相隔一个不同字符的另一段 [j + 1, k)，如果不存在则 k = j + 1
            int k = j + 1;
            while (k < n && text.charAt(k) == text.charAt(i)) ++k;
            ans = Math.max(ans, Math.min(k - i, map.getOrDefault(text.charAt(i), 0)));
            i = j;
        }
        return ans;
    }
}
