package LeetCode_Revice.erchashu;

import LeetCode.TreeNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/26 23:01
 * @desc:
 */
public class p114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        TreeNode cur = root;
        while (cur != null) {
            cur = cur.right;
        }
        cur.right = temp;
    }
}
