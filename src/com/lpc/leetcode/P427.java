package com.lpc.leetcode;

import org.junit.Test;

/**
 * @author byu_rself
 * @date 2022/4/29 9:04
 */
public class P427 {

    @Test
    public void solution() {
        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(construct(grid));
    }

    public Node construct(int[][] grid) {
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
    }

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
