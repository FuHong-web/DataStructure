package LeetCode;

import Tree.TreeNode;

/**
 * @author: Yan Tong xue
 * @Created:2025/11/6 11:24
 * @desc:力扣第112题：路径总和
 */
public class Problem112 {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root==null){
            return false;
        }
        if (root.left==null||root.right==null){
            return root.val==targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
