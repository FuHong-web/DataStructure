package LeetCode_Revice5.erchashu;

import LeetCode.TreeNode;

/*二叉树的公共祖先*/
public class p236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p == root || q == root || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}
