package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/26 19:52
 * @desc:236.二叉树最近的公共祖先（深度优先搜索+递归）
 */
public class Problem236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right= lowestCommonAncestor(root.right,p,q);
        if (left!=null && right!=null) return root;
        return left!=null ? left:right;
    }
}
