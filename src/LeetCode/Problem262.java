package LeetCode;



/**
 * @author: Yan Tong xue
 * @Created:2025/11/11 10:25
 * @desc:力扣第262题:二叉树的翻转
 */
public class Problem262 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
}}
