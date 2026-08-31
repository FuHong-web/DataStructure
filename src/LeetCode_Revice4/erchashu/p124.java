package LeetCode_Revice4.erchashu;

import LeetCode.TreeNode;

import java.awt.event.MouseAdapter;

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
       int maxL = Math.max(0,dfs(root.left));
       int maxR = Math.max(0,dfs(root.right));
       maxSum = Math.max(maxL+maxR+root.val,maxSum);
       return Math.max(maxL,maxR)+root.val;
    }
}
