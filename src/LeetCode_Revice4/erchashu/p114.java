package LeetCode_Revice4.erchashu;

import LeetCode.TreeNode;
import com.sun.source.tree.Tree;

/*二叉树展开为链表*/
public class p114 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode rightTemp = root.right;
        root.right = root.left;
        TreeNode cur = root;
        while (cur.right!=null){
            cur = cur.right;
        }
        cur.right = rightTemp;
    }
}
