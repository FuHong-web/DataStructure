package LeetCode_Revice4.erchashu;

import LeetCode.TreeNode;

/*二叉树的最大路径和*/
public class p124 {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode root)  {
        if(root == null) return 0;
        int lMax = Math.max(0,dfs(root.left));
        int rMax = Math.max(0,dfs(root.right));
        maxSum = Math.max(lMax +rMax + root.val,maxSum);
        return root.val + Math.max(lMax,rMax);
    }
}
