package LeetCode_Revice2.erchashu;

import LeetCode.TreeNode;

import java.util.stream.StreamSupport;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/18 23:30
 * @desc:从前序和中序遍历构造二叉树
 */
public class p105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        // 前序第一个是当前根
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        // 中序找到根的分割点
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }

        // ========== 左子树数组 ==========
        int[] leftPre = new int[index];
        // pre从1开始，取index个元素（跳过根，左子树全部前序）
        System.arraycopy(preorder, 1, leftPre, 0, index);

        int[] leftIn = new int[index];
        // 【修复】中序从0开始取index个，对应 0 ~ index-1 左子树
        System.arraycopy(inorder, 0, leftIn, 0, index);
        root.left = buildTree(leftPre, leftIn);

        // ========== 右子树数组 ==========
        int rightLen = inorder.length - index - 1;
        int[] rightPre = new int[rightLen];
        System.arraycopy(preorder, index + 1, rightPre, 0, rightLen);

        int[] rightIn = new int[rightLen];
        System.arraycopy(inorder, index + 1, rightIn, 0, rightLen);
        root.right = buildTree(rightPre, rightIn);

        return root;
    }
}
