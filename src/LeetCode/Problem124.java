package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/26 21:31
 * @desc:二叉树的最大路径和（递归）
 */
public class Problem124 {
    public int maxPathSum(TreeNode root) {
        int[] res = {root.val};
        dfs(root,res);
        return res[0];
    }
    private int dfs(TreeNode root,int[] res) {
        if (root == null) {
            return 0;
        }
        int lmax = Math.max(0,dfs(root.left,res));
        int rmax = Math.max(0,dfs(root.right,res));
        res[0] = Math.max(res[0],lmax + rmax + root.val);
        return root.val + Math.max(lmax,rmax);

    }
}
