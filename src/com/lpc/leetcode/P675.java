package com.lpc.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Cut Off Trees for Golf Event
 *
 * @author byu_rself
 * @date 2022/5/23 18:02
 */
public class P675 {

    @Test
    public void solution() {
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(0, 0, 4);
        List<Integer> list3 = Arrays.asList(7, 6, 5);
        forest.add(list1);
        forest.add(list2);
        forest.add(list3);
        System.out.println(cutOffTree(forest));
    }

    int N = 50;
    int[][] g = new int[N][N];
    int n, m;
    List<int[]> list = new ArrayList<>();

    public int cutOffTree(List<List<Integer>> forest) {
        // 遍历所有的行和列， 预处理数组找到所有树木的位置
        n = forest.size();
        m = forest.get(0).size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 把列表转成数组， 并找到所有树木的位置
                g[i][j] = forest.get(i).get(j);
                // 等于 1 就不用判断了， 如果不是左上角等于 1 ， 就一定遍历不完
                // 用一个三元数组来储存 树的高度， 和树的位置(x, y 坐标)
                if (g[i][j] > 1) list.add(new int[]{g[i][j], i, j});
            }
        }
        // 按 树的高度， 从低到高对树进行排序
        Collections.sort(list, (a, b) -> a[0] - b[0]); // 匿名内部类 + Lambda 表达式，
        if (g[0][0] == 0) return -1; // 从左上角开始， 所以左上角一定要能走
        int x = 0, y = 0, ans = 0;
        for (int[] ne : list) { // 把所有树从低到高遍历一遍
            int nx = ne[1], ny = ne[2]; // 当前的坐标
            int d = bfs(x, y, nx, ny); // 进行广搜， 往四个方向走
            if (d == -1) return -1; // 如果都走不通， 那就返回 -1, 说明遍历不完
            ans += d;
            x = nx;
            y = ny;
        }
        return ans;
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 规定上下左右行走数组

    int bfs(int X, int Y, int P, int Q) {
        if (X == P && Y == Q) return 0; // 判断左上角的情况， 如果是最小， 返回0
        boolean[][] vis = new boolean[n][m]; // 判断每个位置是否能走
        Deque<int[]> d = new ArrayDeque<>(); // 创建一个双向队列
        d.addLast(new int[]{X, Y}); // 将当前位置加入到队列中
        vis[X][Y] = true; // 表示已经砍过这个位置的树了，就不能再走了
        int ans = 0;
        while (!d.isEmpty()) {
            int size = d.size(); // 广搜每一层的大小
            while (size-- > 0) {
                int[] info = d.pollFirst();
                int x = info[0], y = info[1];
                for (int[] di : dirs) { // 从方向数组中取出一个元素
                    int nx = x + di[0], ny = y + di[1]; // 改变坐标
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 越界情况
                    if (g[nx][ny] == 0 || vis[nx][ny]) continue; // 判断不能走的情况
                    if (nx == P && ny == Q) return ans + 1;
                    // 下面是没有达到目标点， 也没有不能走或者越界等特殊情况
                    d.addLast(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
            // 该点广搜完， 进入下一个层的广搜， 步数加一
            ans++;
        }
        return -1;
    }
}
