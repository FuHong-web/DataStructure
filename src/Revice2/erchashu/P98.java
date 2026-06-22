package Revice2.erchashu;

import LeetCode.TreeNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/21 22:23
 * @desc:验证二叉搜索树
 */
public class P98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode node,long lower,long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        //左子树：上限换成当前节点值，下限不变
        //右子树：下限换成当前节点值，上限不变
        return isValidBST(node.left,lower,node.val) && isValidBST(node.right,node.val,upper); // lower和upper是固定的最大最小边界
    }
}

