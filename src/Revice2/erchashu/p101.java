package Revice2.erchashu;

import LeetCode.TreeNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/21 11:46
 * @desc:对称二叉树
 */
public class p101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left,root.right);
    }
    public boolean check(TreeNode p,TreeNode q) {
        if (p== null && q== null) return true;
        if (q == null || p == null) return false;
        return p.val == q.val && check(p.left,q.right)  && check(p.right,q.left);
    }

}
