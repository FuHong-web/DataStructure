package LeetCode_Revice3.erchashu;

import LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*路径总和*/
public class p437 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int total = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            // 注意：0L，long类型！！
            total += dfs(node, 0L, targetSum);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return total;
    }

    private int dfs(TreeNode node, long curSum, int targetSum) {
        if (node == null) return 0;
        curSum += node.val;
        int count = 0;
        if (curSum == targetSum) {
            count++;
        }
        count += dfs(node.left, curSum, targetSum);
        count += dfs(node.right, curSum, targetSum);
        return count;
    }
}
