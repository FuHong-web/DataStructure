package Revice2.erchashu;

import LeetCode.ListNode;
import LeetCode.TreeNode;

import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/25 22:21
 * @desc:最近公共祖先
 */
public class p236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root.left == p || root.right == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
