package LeetCode;

import Tree.TreeNode;

/**
 * @author: Yan Tong xue
 * @Created:2025/11/8 22:41
 * @desc:完全二叉树的结点个数
 */
public class Problem222 {
    class Solution {
        public int countNodes(TreeNode root) {
            if(root == null){
                return 0;
            }
            int left = countLevel(root.left);
            int right = countLevel(root.right);
            if(left == right){
                return countNodes(root.right) + (1<<left);
            }else{
                return countNodes(root.left) + (1<<right);
            }
        }
        private int countLevel(TreeNode root){
            int level = 0;
            while(root != null){
                level++;
                root = root.left;
            }
            return level;
        }
    }

}
