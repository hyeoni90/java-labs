package com.hyeonah.javalabs.algorithm.top50coding.graph.dfs;

import com.hyeonah.javalabs.algorithm.top50coding.graph.TreeNode;

import java.util.Stack;

/**
 * Created by hyeonahlee on 2020-12-19.
 *
 * DFS stack
 */
public class MaximumDepthOfBinaryTreeWithDFS {

    public static void main(final String[] args) {
        final MaximumDepthOfBinaryTreeWithDFS maximumDepthOfBinaryTreeWithDFS = new MaximumDepthOfBinaryTreeWithDFS();

        final TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        node.left.left.left = new TreeNode(6);

        System.out.println("maxLevel: " + maximumDepthOfBinaryTreeWithDFS.dfs(node));
    }

    private int dfs(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        final Stack<TreeNode> stack = new Stack<>();
        final Stack<Integer> valueStack = new Stack<>();

        stack.push(root);
        valueStack.push(1);

        int maxLevel = 0;

        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final int level = valueStack.pop();
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

