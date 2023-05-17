package com.lpc.leetcode;

/**
 * 判断两个事件是否存在冲突
 *
 * @author byu_rself
 * @date 2023/5/17 9:07
 */
public class P2446 {

    public boolean haveConflict(String[] event1, String[] event2) {
        // event1的开始时间大于event2的结束时间或者event1的结束时间小于event2的开始时间则没有冲突
        return !(event1[0].compareTo(event2[1]) > 0 || event1[1].compareTo(event2[0]) < 0);
    }
}
