package LeetCode_Revice.erchashu;

import LeetCode.TreeNode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/29 21:48
 * @desc:二叉树的最大路径和
 */
public class p124 {
    public int maxPathSum(TreeNode root) {
        int[] res = {root.val};//因为二叉树里所有节点都可能是负数！
        dfs(root,res);
        return res[0];
    }
    private int dfs(TreeNode root,int[] res) {
        if (root == null) {
            return 0;
        }
        int lmax = Math.max(0,dfs(root.left,res));
        int rmax = Math.max(0,dfs(root.right,res));//左右结点值有可能是负数
        res[0] = Math.max(res[0],lmax + rmax + root.val);
        return root.val + Math.max(lmax,rmax);//只能选一条路，不然有结点重和
    }
}
