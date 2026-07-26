package LeetCode_Revice3.erchashu;

import LeetCode.TreeNode;

/*二叉树的最大深度*/
public class p104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxD = 0;
        int lD = maxDepth(root.left);
        int rD = maxDepth(root.right);
        maxD = Math.max(lD,rD) + 1;
        return maxD;
    }
}

