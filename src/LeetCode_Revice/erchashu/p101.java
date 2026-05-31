package LeetCode_Revice.erchashu;

import LeetCode.Problem101;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/11 23:27
 * @desc:对称二叉树
 */
public class p101 {
    public boolean isSymmetric(TreeNode root) {
         return check(root.left,root.right);
    }
    private boolean check (TreeNode p,TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }
}
