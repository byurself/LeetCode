package com.lpc.leetcode;

import org.junit.Test;

/**
 * 文件夹操作日志搜集器
 *
 * @author byu_rself
 * @date 2022/9/9 0:04
 */
public class P1598 {

    @Test
    public void solution() {
        String[] logs = new String[]{"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(minOperations(logs));
    }

    public int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (ans > 0) ans--;
            } else if (log.equals("./")) ;
            else ans++;
        }
        return ans;
    }
}
