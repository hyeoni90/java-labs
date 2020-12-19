package com.hyeonah.studyjava.algorithm.javaCodingTop50.graph.dfs;

import java.util.Stack;

/**
 * Created by hyeonahlee on 2020-12-19.
 *
 * DFS stack
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        node.left.left.left = new TreeNode(6);

        System.out.println("maxLevel: " + maximumDepthOfBinaryTree.dfs(node));
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        stack.push(root);
        valueStack.push(1);

        int maxLevel = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int level = valueStack.pop();
            maxLevel = Math.max(maxLevel, level);

            if (node.left != null) {
                stack.push(node.left);
                valueStack.push(1 + level);
            }
            if (node.right != null) {
                stack.push(node.right);
                valueStack.push(1 + level);
            }
        }
        return maxLevel;
    }
}

class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}
