package LeetCode;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2025/11/8 21:40
 * @desc:力扣第145题：二叉树的后序遍历
 */
public class Problem145 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            postorder(root, res);
            return res;
        }
        public void postorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    }


