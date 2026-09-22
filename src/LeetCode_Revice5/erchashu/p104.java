package LeetCode_Revice5.erchashu;

import LeetCode.TreeNode;

/*二叉树的最大深度*/
public class p104
{
    public int maxDepth(TreeNode root){
        int maxDepth;
        if(root == null) return 0;
        int lMax = maxDepth(root.left);
        int rMax = maxDepth(root.right);
        maxDepth = Math.max(lMax,rMax)+1;
        return maxDepth;

    }
}
