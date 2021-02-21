package com.hyeonah.javalabs.algorithm.top50coding.graph.bfs;

import com.hyeonah.javalabs.algorithm.top50coding.graph.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hyeonahlee on 2020-12-20.
 *
 * BFS - Queue
 */
public class MaximumDepthOfBinaryTreeWithBFS {

    public static void main(final String[] args) {
        final MaximumDepthOfBinaryTreeWithBFS maximumDepthOfBinaryTreeWithBFS = new MaximumDepthOfBinaryTreeWithBFS();
        final TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.right.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);

        System.out.println("maxLevel: " + maximumDepthOfBinaryTreeWithBFS.dfs(tree));

    }

    private int dfs(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                final TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return level;
    }
}
