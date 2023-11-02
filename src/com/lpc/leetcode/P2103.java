package com.lpc.leetcode;

/**
 * 环和杆
 *
 * @author byu_rself
 * @date 2023/11/2 9:59
 */
public class P2103 {

    public int countPoints(String rings) {
        int n = rings.length();
        int[] d = new int['Z'];
        d['R'] = 1;
        d['G'] = 2;
        d['B'] = 4;
        int[] mask = new int[10];
        for (int i = 0; i < n; i += 2) {
            char c = rings.charAt(i);
            int j = rings.charAt(i + 1) - '0';
            mask[j] |= d[c];
        }
        int ans = 0;
        for (int x : mask) {
            if (x == 7) ++ans;
        }
        return ans;
    }
}
