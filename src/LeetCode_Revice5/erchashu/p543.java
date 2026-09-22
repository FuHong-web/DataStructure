package LeetCode_Revice5.erchashu;

import LeetCode.TreeNode;

import javax.print.attribute.standard.MediaSize;

/*二叉树的直径*/
public class p543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root){
        dfs(root);
        return ans-1;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int LmaX = dfs(root.left);
        int rMAX  = dfs(root.right);
        ans = Math.max(LmaX+rMAX, ans)+1;
        return Math.max(LmaX,rMAX)+1;
    }
}
