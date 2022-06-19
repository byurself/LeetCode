package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出现次数最多的子树元素和
 *
 * @author byu_rself
 * @date 2022/6/19 16:02
 */
public class P508 {

    @Test
    public void solution() {

    }

    Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
    int maxCnt = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int s = entry.getKey(), c = entry.getValue();
            if (c == maxCnt) {
                list.add(s);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + dfs(node.left) + dfs(node.right);
        cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        maxCnt = Math.max(maxCnt, cnt.get(sum));
        return sum;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
