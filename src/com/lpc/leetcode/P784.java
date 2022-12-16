package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 *
 * @author byu_rself
 * @date 2022/10/30 13:06
 */
public class P784 {

    List<String> list = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        char[] cs = S.toCharArray();
        dfs(cs, 0);
        return list;
    }

    private void dfs(char[] charArray, int index) {
        if (index == charArray.length) {
            list.add(new String(charArray));
            return;
        }
        dfs(charArray, index + 1);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            dfs(charArray, index + 1);
        }
    }
}
