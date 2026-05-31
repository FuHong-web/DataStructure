package LeetCode_Revice.erchashu;

import LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/29 21:14
 * @desc:路径总和iii
 */
public class p437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int total = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            total += dfs(node,0,targetSum);
            if (node != null) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
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
            count+=1;
        }
        count += dfs(node.left,curSum,targetSum);
        count += dfs(node.right,curSum,targetSum);

        return count;
    }
}
