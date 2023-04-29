package com.lpc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 完美矩形
 *
 * @author byu_pointelf
 * @date 2023/4/29 19:53
 */
public class P391 {

    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        int[][] point = new int[n * 2][4]; // 存储形式：(x,y1,y2,flag)
        for (int i = 0, idx = 0; i < n; ++i) {
            int[] rectangle = rectangles[i];
            point[idx++] = new int[]{rectangle[0], rectangle[1], rectangle[3], 1};
            point[idx++] = new int[]{rectangle[2], rectangle[1], rectangle[3], -1};
        }
        Arrays.sort(point, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        n *= 2;
        List<int[]> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for (int l = 0; l < n; ) {
            int r = l;
            l1.clear();
            l2.clear();
            while (r < n && point[r][0] == point[l][0]) ++r;
            for (int i = l; i < r; ++i) {
                int[] cur = new int[]{point[i][1], point[i][2]};
                List<int[]> list = point[i][3] == 1 ? l1 : l2;
                if (list.isEmpty()) {
                    list.add(cur);
                } else {
                    int[] pre = list.get(list.size() - 1);
                    if (cur[0] < pre[1]) return false; // 重叠
                    else if (cur[0] == pre[1]) pre[1] = cur[1]; // 首尾相连
                    else list.add(cur);
                }
            }
            if (l > 0 && r < n) {
                if (l1.size() != l2.size()) return false;
                for (int i = 0; i < l1.size(); i++) {
                    if (l1.get(i)[0] == l2.get(i)[0] && l1.get(i)[1] == l2.get(i)[1]) continue;
                    return false;
                }
            } else {
                if (l1.size() + l2.size() != 1) return false;
            }
            l = r;
        }
        return true;
    }
}
