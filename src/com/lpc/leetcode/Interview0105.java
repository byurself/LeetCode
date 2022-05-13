package com.lpc.leetcode;

import org.junit.Test;

/**
 * One Away LCCI
 *
 * @author byu_rself
 * @date 2022/5/13 9:31
 */
public class Interview0105 {

    @Test
    public void solution() {
        String first = "teacher";
        String second = "attacher";
        System.out.println(oneEditAway(first, second));
    }

    /**
     * 优化冗余代码
     *
     * @param first  较长字符串
     * @param second 较短字符串
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int firstLength = first.length();
        int secondLength = second.length();
        if (Math.abs(firstLength - secondLength) > 1) {
            return false;
        }
        if (firstLength < secondLength) {
            return oneEditAway(second, first);
        }
        int i = 0, j = 0, count = 0;

        while (i < firstLength && j < secondLength && count <= 1) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                if (firstLength == secondLength) {
                    j++;
                }
                count++;
            }
        }
        return count <= 1;
    }

    public boolean oneEditAway1(String first, String second) {
        int firstLength = first.length();
        int secondLength = second.length();
        int count = Math.abs(firstLength - secondLength);
        if (count > 1) {
            return false;
        }
        int flag = 0;
        int i = 0, j = 0;
        if (firstLength == secondLength) {
            for (i = 0; i < firstLength; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
        } else if (firstLength > secondLength) {
            while (j < secondLength) {
                if (first.charAt(i) != second.charAt(j)) {
                    if (flag == 0) {
                        flag++;
                        i++;
                    } else {
                        count++;
                    }
                } else {
                    i++;
                    j++;
                }
                if (count > 2) {
                    return false;
                }
            }
        } else {
            while (i < firstLength) {
                if (first.charAt(i) != second.charAt(j)) {
                    if (flag == 0) {
                        flag++;
                        j++;
                    } else {
                        count++;
                    }
                } else {
                    i++;
                    j++;
                }
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
