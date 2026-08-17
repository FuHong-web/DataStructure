package LeetCode_Revice4.erchashu;

import LeetCode.TreeNode;

/*对称二叉树*/
public class p101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left,root.right);
    }
    private boolean check(TreeNode left,TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return left.val == right.val && check(left.left,right.right) && check(left.right,right.left);
    }
}
