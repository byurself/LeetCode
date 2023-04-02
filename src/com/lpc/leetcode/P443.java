package com.lpc.leetcode;

/**
 * 压缩字符串
 *
 * @author byu_rself
 * @date 2023/4/2 19:25
 */
public class P443 {

    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0, j = 0;
        while (i < n) {
            int index = i;
            while (index < n && chars[i] == chars[index]) ++index;
            int cnt = index - i;
            chars[j++] = chars[i];
            if (cnt > 1) {
                int l = j, r = j;
                while (cnt > 0) {
                    chars[r++] = (char) (cnt % 10 + '0');
                    cnt /= 10;
                }
                reverse(chars, l, r - 1);
                j = r;
            }
            i = index;
        }
        return j;
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            ++l;
            --r;
        }
    }

/*    public int compress1(char[] chars) {
        int n = chars.length;
        int i = 0, j = 0;
        while (i < n) {
            int index = i;
            while (index < n && chars[i] == chars[index]) ++index;
            int cnt = index - i;
            chars[j++] = chars[i];
            if (cnt > 1) {
                int l = j, r = j;
                while (cnt > 0) {
                    chars[r++] = (char) (cnt % 10 + '0');
                    cnt /= 10;
                }
                reverse(chars, l, r - 1);
                j = r;
            }
            i = index;
        }
        return j;
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            ++l;
            --r;
        }
    }*/
}
