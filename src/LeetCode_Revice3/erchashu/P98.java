package LeetCode_Revice3.erchashu;

import LeetCode.Problem101;
import LeetCode.TreeNode;

/*验证二叉搜索树*/
public class P98 {
        public boolean isValidBST(TreeNode root) {
            return isOk(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }
        private boolean isOk(TreeNode root,long lower,long upper) {
            if (root == null) return true;
            if (root.val <= lower || root.val >= upper) return false;
            boolean isLOk = isOk(root.left,lower,root.val);
            boolean isRok = isOk(root.right,root.val,upper);
            return isRok && isLOk;
        }

}
