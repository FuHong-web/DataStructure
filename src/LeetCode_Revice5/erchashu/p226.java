package LeetCode_Revice5.erchashu;

import LeetCode.TreeNode;

/*翻转二叉树*/
public class p226
{
    public TreeNode invertTree(TreeNode root){
        if(root == null) return null;
        TreeNode newLeft = invertTree(root.left);
        TreeNode newRight = invertTree(root.right);
        root.left = newRight;
        root.right = newLeft;
        return root;
    }
}
