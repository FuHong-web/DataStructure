package LeetCode_Revice4.erchashu;

import LeetCode.TreeNode;

/*二叉树的直径*/
public class p543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans -1;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int lMax = dfs(root.left);
        int Rmax = dfs(root.right);
        ans = Math.max(ans,lMax+Rmax+1);
        return Math.max(lMax,Rmax)+1;
    }
}
