package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 模糊坐标
 *
 * @author byu_rself
 * @date 2023/12/28 16:29
 */
public class P816 {

    String s;

    public List<String> ambiguousCoordinates(String ss) {
        s = ss.substring(1, ss.length() - 1);
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            for (String x : search(0, i)) {
                for (String y : search(i + 1, n - 1)) {
                    ans.add(String.format("(%s, %s)", x, y));
                }
            }
        }
        return ans;
    }

    private List<String> search(int start, int end) {
        List<String> ans = new ArrayList<>();
        if (start == end || s.charAt(start) != '0') ans.add(s.substring(start, end + 1));
        for (int i = start; i < end; ++i) { // 枚举小数点：在 i 后面追加小数点
            String a = s.substring(start, i + 1), b = s.substring(i + 1, end + 1);
            if (a.length() > 1 && a.charAt(0) == '0') continue;
            if (b.charAt(b.length() - 1) == '0') continue;
            ans.add(a + "." + b);
        }
        return ans;
    }
}
