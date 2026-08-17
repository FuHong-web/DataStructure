package LeetCode_Revice4.erchashu;

import LeetCode.TreeNode;

/*翻转二叉树*/
public class p226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
