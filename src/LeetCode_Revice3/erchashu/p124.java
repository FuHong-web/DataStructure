package LeetCode_Revice3.erchashu;

import LeetCode.TreeNode;

/*二叉树的最大路径和*/
public class p124
{
    int maxSum;
    public int maxPathSum(TreeNode root){
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int Lmax=Math.max(0,dfs(root.left));
        int Rmax= Math.max(0,dfs(root.right));
        maxSum = Math.max(maxSum,Lmax+Rmax+root.val);
        return Math.max(Lmax,Rmax)+root.val;
    }
}
