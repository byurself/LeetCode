package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 奖励最顶尖的K名学生
 *
 * @author byu_rself
 * @date 2023/10/11 9:19
 */
public class P2512 {

    @Test
    public void solution() {
        String[] positive_feedback = new String[]{"smart", "brilliant", "studious"};
        String[] negative_feedback = new String[]{"not"};
        String[] report = new String[]{"this student is not studious", "the student is smart", "the student is smart"};
        int[] student_id = new int[]{1, 2, 3};
        int k = 2;
        List<Integer> list = topStudents(positive_feedback, negative_feedback, report, student_id, k);
        list.forEach(System.out::println);
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveSet = new HashSet<>(List.of(positive_feedback));
        Set<String> negativeSet = new HashSet<>(List.of(negative_feedback));
        int n = report.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            int sid = student_id[i], t = 0;
            for (String s : report[i].split(" ")) {
                if (positiveSet.contains(s)) t += 3;
                if (negativeSet.contains(s)) t -= 1;
            }
            arr[i] = new int[]{t, sid};
        }
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ans.add(arr[i][1]);
        }
        return ans;
    }
}
