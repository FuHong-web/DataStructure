package LeetCode_Revice3.erchashu;

import LeetCode.TreeNode;

import javax.print.DocFlavor;

/*二叉树的直径*/
public class p543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans-1;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int L = dfs(root.left);
        int R = dfs(root.right);
        ans = Math.max(ans,L+R+1);
        return Math.max(L,R) + 1;
    }
}
