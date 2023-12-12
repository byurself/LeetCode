package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 下一个更大元素IV
 *
 * @author byu_rself
 * @date 2023/12/12 10:02
 */
public class P2454 {

    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[] s = new int[n], t = new int[n];
        int ss = -1, tt = -1;
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            while (tt > -1 && nums[t[tt]] < x) {
                ans[t[tt--]] = x; // t 栈顶的下下个更大元素是 x
            }
            int temp = ss;
            while (ss > -1 && nums[s[ss]] < x) {
                --ss; // s 栈顶的下一个更大元素是 x
            }
            System.arraycopy(s, ss, t, tt, temp - ss);
            tt += temp - ss;
            s[++ss] = i;
        }
        return ans;
    }

    public int[] secondGreaterElement2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<Integer> s = new ArrayList<>(), t = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            while (!t.isEmpty() && nums[t.get(t.size() - 1)] < x) {
                ans[t.get(t.size() - 1)] = x; // t 栈顶的下下个更大元素是 x
                t.remove(t.size() - 1);
            }
            int j = s.size();
            while (j > 0 && nums[s.get(j - 1)] < x) {
                j--; // s 栈顶的下一个更大元素是 x
            }
            List<Integer> popped = s.subList(j, s.size());
            t.addAll(popped); // 把从 s 弹出的这一整段元素加到 t
            popped.clear(); // 弹出一整段元素
            s.add(i); // 当前元素的下标加到 s 栈顶
        }
        return ans;
    }

    public int[] secondGreaterElement1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        TreeSet<Integer> ts = new TreeSet<>();
        for (int[] p : arr) {
            int i = p[1];
            Integer j = ts.higher(i);
            if (j != null && ts.higher(j) != null) {
                ans[i] = nums[ts.higher(j)];
            }
            ts.add(i);
        }
        return ans;
    }
}
