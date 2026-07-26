package LeetCode_Revice3.erchashu;

import LeetCode.Problem101;
import LeetCode.TreeNode;

/*对称二叉树*/
public class p101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    private boolean check(TreeNode l1,TreeNode l2) {
        if (l1 == null && l2 == null) return true;
        if (l1 == null || l2 == null) return false;
        return l1.val == l2.val && check(l1.left,l2.right) && check(l1.right,l2.left);
    }
}
