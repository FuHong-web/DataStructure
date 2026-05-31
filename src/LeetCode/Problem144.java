package LeetCode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2025/11/8 20:50
 * @desc:力扣第144题：二叉树的前序遍历
 */
public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        class Solution {
            public List<Integer> preorderTraversal(TreeNode root) {
                List<Integer> res = new ArrayList<Integer>();
                preorder(root, res);
                return res;
            }

            public void preorder(TreeNode root, List<Integer> res) {
                if (root == null) {
                    return ;
                }
                res.add(root.val);
                preorder(root.left, res);
                preorder(root.right, res);
            }
        }
        return null;
    }
}

