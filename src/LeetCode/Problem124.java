package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/26 21:31
 * @desc:二叉树的最大路径和（递归）
 */
public class Problem124 {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int Lmax = Math.max(0,dfs(root.left));
        int Rmax = Math.max(0,dfs(root.right));
        maxSum = Math.max(Lmax + Rmax + root.val,maxSum);
        return root.val + Math.max(Lmax,Rmax);
    }
}
