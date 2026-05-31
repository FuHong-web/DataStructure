package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/22 22:55
 * @desc: 路径总和iii
 */
public class Problem437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int total = 0;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            total += dfs(node, 0, targetSum);
            if (node != null) {
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return total;
    }
    private int dfs(TreeNode node, long curSum, int targetSum) {
        if (node == null) {
            return 0;
        }
        curSum += node.val;
        int count = 0;
        if (curSum == targetSum) {
            count += 1;
        }
        count += dfs(node.left, curSum, targetSum);
        count += dfs(node.right, curSum, targetSum);
        return count;
    }
}
