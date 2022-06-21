package com.lpc.leetcode;

import org.junit.Test;

/**
 * IP 地址无效化
 *
 * @author byu_rself
 * @date 2022/6/21 18:17
 */
public class P1108 {

    @Test
    public void solution() {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr(address));
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
