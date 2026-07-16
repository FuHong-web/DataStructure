package LeetCode_Revice2.erchashu;

import LeetCode.TreeNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/21 11:36
 * @desc:二叉树的深度
 */
public class p104 {
    public int maxDepth(TreeNode root) {
        int maxDepth;
        if (root == null) {
            return 0;
        }else {
            int maxLeft = maxDepth(root.left);
            int maxRight = maxDepth(root.right);
            maxDepth = Math.max(maxLeft,maxRight) +1;
        }
        return maxDepth;
    }
}
