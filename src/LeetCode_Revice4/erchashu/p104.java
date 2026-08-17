package LeetCode_Revice4.erchashu;

import LeetCode.TreeNode;

/*二叉树的最大深度*/
public class p104 {
    public int maxDepth(TreeNode root) {
        int maxD = 0;
        if(root == null) return 0;
        int Lmax = maxDepth(root.left);
        int Rmax = maxDepth(root.right);
        maxD = Math.max(Lmax,Rmax) +1;
        return maxD;
    }
}
