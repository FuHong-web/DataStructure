package LeetCode_Revice5.erchashu;

import LeetCode.TreeNode;

/*路径综总和*/
public class p437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        //当前节点作为起点的路径数 + 左子树所有起点路径数 + 右子树所有起点路径数
        int rootCount = dfs(root, 0L, targetSum);
        int leftCount = pathSum(root.left, targetSum);
        int rightCount = pathSum(root.right, targetSum);
        return rootCount + leftCount + rightCount;
    }

    // dfs：以node为起点向下，求满足路径和的数量，curSum用long防止int溢出
    private int dfs(TreeNode node, long curSum, int targetSum) {
        if (node == null) return 0;
        int count = 0;
        curSum += node.val;
        if (curSum == targetSum) {
            count++;
        }
        //累加左右子树找到的路径
        count += dfs(node.left, curSum, targetSum);
        count += dfs(node.right, curSum, targetSum);
        return count;
    }
}
