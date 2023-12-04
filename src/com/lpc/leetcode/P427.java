package com.lpc.leetcode;

import org.junit.Test;

/**
 * 建立四叉树
 *
 * @author byu_rself
 * @date 2022/4/29 9:04
 */
public class P427 {

    @Test
    public void solution() {
        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(construct(grid));
    }

    int[][] grid;

    public Node construct(int[][] grid) {
        this.grid = grid;
        return dfs(0, 0, grid.length);
    }

    private Node dfs(int top, int left, int size) {
        if (size == 1) return new Node(grid[top][left] == 1, true);
        int subSize = size / 2;
        Node topLeft = dfs(top, left, subSize);
        Node topRight = dfs(top, left + subSize, subSize);
        Node bottomLeft = dfs(top + subSize, left, subSize);
        Node bottomRight = dfs(top + subSize, left + subSize, subSize);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        } else {
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    /*int[][] grid;
    int[][] sum;

    public Node construct(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(0, 0, n - 1, n - 1);
    }

    private Node dfs(int a, int b, int c, int d) {
        int cur = sum[c + 1][d + 1] - sum[a][d + 1] - sum[c + 1][b] + sum[a][b];
        int dx = c - a + 1, dy = d - b + 1, total = dx * dy;
        if (cur == 0 || cur == total) return new Node(grid[a][b] == 1, true);
        return new Node(
                grid[a][b] == 1,
                false,
                dfs(a, b, a + dx / 2 - 1, b + dy / 2 - 1),
                dfs(a, b + dy / 2, a + dx / 2 - 1, d),
                dfs(a + dx / 2, b, c, b + dy / 2 - 1),
                dfs(a + dx / 2, b + dy / 2, c, d)
        );
    }*/

    /*public Node construct(int[][] grid) {
        return formNode(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    public Node formNode(int[][] grid, int l, int r, int low, int high) {
        if (allSame(grid, l, r, low, high)) {
            return new Node(grid[l][low] == 1, true);
        }
        int mid1 = (l + r) / 2, mid2 = (low + high) / 2;
        Node topLeft = formNode(grid, l, mid1, low, mid2);
        Node topRight = formNode(grid, l, mid1, mid2 + 1, high);
        Node bottomLeft = formNode(grid, mid1 + 1, r, low, mid2);
        Node bottomRight = formNode(grid, mid1 + 1, r, mid2 + 1, high);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public boolean allSame(int[][] grid, int l, int r, int low, int high) {
        // 判断矩阵某区域是否同值
        for (int i = l; i <= r; i++) {
            for (int j = low; j <= high; j++) {
                if (grid[i][j] != grid[l][low]) {
                    return false;
                }
            }
        }
        return true;
    }*/

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public String toString() {
            return "[" +
                    "[" + val +
                    ", " + isLeaf +
                    "]" +
                    ']';
        }
    }
}
