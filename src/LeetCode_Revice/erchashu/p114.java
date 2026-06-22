package LeetCode_Revice.erchashu;

import LeetCode.TreeNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/26 23:01
 * @desc:
 */
public class p114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        // 1. 递归把左子树、右子树各自拉成单链
        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right; // 先保存原来的右链
        root.right = root.left;     // 把左链接到root右边
        root.left = null;           // 必须清空左子树，题目要求左为null

        // 2. 找到当前右链的末尾节点
        TreeNode cur = root;
        while (cur.right != null) { // 你这里写 cur != null 会死循环
            cur = cur.right;
        }
        cur.right = temp; // 原来的右链接在末尾
    }
}
