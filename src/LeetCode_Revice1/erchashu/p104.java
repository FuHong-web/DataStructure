package LeetCode_Revice1.erchashu;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/11 23:14
 * @desc:二叉树的最大深度
 */
public class p104 {
    public int maxDepth(TreeNode root) {
        int maxD;
        if (root == null) {
            return 0;
        }else {
            int maxL = maxDepth(root.left);
            int maxR = maxDepth(root.right);
            maxD = Math.max(maxL,maxR) + 1;
        }
        return maxD;
    }
}

