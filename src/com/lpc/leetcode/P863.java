package com.lpc.leetcode;

import java.util.*;

/**
 * 二叉树中所有距离为K的结点
 *
 * @author byu_rself
 * @date 2023/4/12 14:46
 */
public class P863 {

    Map<Integer, List<Integer>> adj = new HashMap<>();
    boolean[] visited = new boolean[510];
    List<Integer> ans = new ArrayList<>();

    private void add(int a, int b) {
        adj.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root);
        visited[target.val] = true;
        find(target.val, k, 0);
        return ans;
    }

    private void find(int node, int k, int cur) {
        if (cur == k) {
            ans.add(node);
            return;
        }
        List<Integer> list = adj.get(node);
        if (list == null) return;
        for (Integer i : list) {
            if (!visited[i]) {
                visited[i] = true;
                find(i, k, cur + 1);
            }
        }
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            add(node.val, node.left.val);
            add(node.left.val, node.val);
            dfs(node.left);
        }
        if (node.right != null) {
            add(node.val, node.right.val);
            add(node.right.val, node.val);
            dfs(node.right);
        }
    }

/*    int N = 510, M = 4 * N, idx = 0;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    boolean[] visited = new boolean[N];
    List<Integer> ans;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs(root);
        visited[target.val] = true;
        find(target.val, k, 0);
        return ans;
    }

    private void find(int node, int k, int cur) {
        if (cur == k) {
            ans.add(node);
            return;
        }
        for (int i = he[node]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!visited[j]) {
                visited[j] = true;
                find(j, k, cur + 1);
            }
        }
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            add(node.val, node.left.val);
            add(node.left.val, node.val);
            dfs(node.left);
        }
        if (node.right != null) {
            add(node.val, node.right.val);
            add(node.right.val, node.val);
            dfs(node.right);
        }
    }*/

/*    int N = 510, M = 4 * N, idx = 0;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    boolean[] visited = new boolean[N];

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Arrays.fill(he, -1);
        dfs(root);
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(target.val);
        visited[target.val] = true;
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                if (k == 0) {
                    ans.add(cur);
                    continue;
                }
                for (int i = he[cur]; i != -1; i = ne[i]) {
                    int j = e[i];
                    if (!visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
            --k;
        }
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            add(node.val, node.left.val);
            add(node.left.val, node.val);
            dfs(node.left);
        }
        if (node.right != null) {
            add(node.val, node.right.val);
            add(node.right.val, node.val);
            dfs(node.right);
        }
    }*/

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
