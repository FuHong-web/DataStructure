package LeetCode_Revice5.erchashu;


import LeetCode.TreeNode;

/*二叉树展开为链表*/
public class p114 {
    public void flatten(TreeNode root){
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode rightNode = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = rightNode;
    }
}
