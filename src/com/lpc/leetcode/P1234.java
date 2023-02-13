package com.lpc.leetcode;

/**
 * 替换子串得到平衡字符串
 *
 * @author byu_rself
 * @date 2023/2/13 13:04
 */
public class P1234 {

    public int balancedString(String s) {
        int length = s.length(), ans = length, m = length / 4;
        int[] cnt = new int[4];
        String t = "QWER";
        for (int i = 0; i < length; i++) {
            cnt[t.indexOf(s.charAt(i))]++;
        }
        if (cnt[0] == m && cnt[1] == m && cnt[2] == m && cnt[3] == m) return 0;
        for (int l = 0, r = 0; r < length; r++) {
            cnt[t.indexOf(s.charAt(r))]--;
            while (cnt[0] <= m && cnt[1] <= m && cnt[2] <= m && cnt[3] <= m) {
                ans = Math.min(ans, r - l + 1);
                cnt[t.indexOf(s.charAt(l++))]++;
            }
        }
        return ans;
    }
}
