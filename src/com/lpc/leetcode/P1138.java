package com.lpc.leetcode;

/**
 * 字母板上的路径
 *
 * @author byu_rself
 * @date 2023/2/12 20:10
 */
public class P1138 {

    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        for (int k = 0; k < target.length(); k++) {
            int t = target.charAt(k) - 'a';
            int x = t / 5, y = t % 5;
            while (j > y) {
                --j;
                ans.append('L');
            }
            while (i > x) {
                --i;
                ans.append('U');
            }
            while (j < y) {
                ++j;
                ans.append('R');
            }
            while (i < x) {
                ++i;
                ans.append('D');
            }
            ans.append("!");
        }
        return ans.toString();
    }
}
