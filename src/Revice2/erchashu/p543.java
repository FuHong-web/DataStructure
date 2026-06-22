package Revice2.erchashu;

import LeetCode.TreeNode;

import javax.swing.text.TabableView;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/21 12:02
 * @desc:二叉树的直径
 */
public class p543 {
    int ans = 1; // 初始化：最少存在1个节点
    public int diameterOfBinaryTree (TreeNode root) {
        if (root== null) return 0;
        depth(root);
        return ans -1;
    }
    public int  depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxL = depth(root.left);
        int maxR = depth(root.right);
        // 更新经过当前节点的最长路径（节点总数）
        ans = Math.max(ans,maxL + maxR + 1);
        // 当前子树最大深度，必须+1计入自身节点
        return Math.max(maxL,maxR) + 1;
    }
}
