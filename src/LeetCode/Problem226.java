package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/13 17:34
 * @desc:力扣第226题：翻转二叉树（递归）
 */
public class Problem226 {
    public TreeNode invertTree(TreeNode root){
        if (root==null){
            return null;
        }
        //先翻转再赋值
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

}
