package Revice2.erchashu;

import LeetCode.TreeNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/22 22:14
 * @desc:二叉树展开为链表
 */
public class p114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        TreeNode cur = root;
        while (cur.right != null) {
             cur = cur.right;
        }
        cur.right = temp;
    }
}
