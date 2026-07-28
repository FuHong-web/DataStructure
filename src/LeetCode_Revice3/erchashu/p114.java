package LeetCode_Revice3.erchashu;

import LeetCode.TreeNode;

/*将二叉树转为链表*/
public class p114 {
    class Solution {
        public void flatten(TreeNode root) {
            if(root == null) return;
            flatten(root.left);
            flatten(root.right);
            TreeNode righTemp = root.right;
            root.right = root.left;
            TreeNode cur = root;
            while(cur!= null) {
                cur = cur.right;
            }
            cur.right = righTemp;
        }
    }
}
