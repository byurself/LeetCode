package com.lpc.leetcode;

/**
 * 老人的数目
 *
 * @author byu_rself
 * @date 2023/10/23 9:17
 */
public class P2678 {

    public int countSeniors(String[] details) {
        int ans = 0;
        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11, 13)) > 60) {
                ++ans;
            }
        }
        return ans;
    }
}
