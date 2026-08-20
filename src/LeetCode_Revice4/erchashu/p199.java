package LeetCode_Revice4.erchashu;

import LeetCode.ListNode;
import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*日二叉树的右视图*/
public class p199 {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res= new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            TreeNode rightNode = null;
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                rightNode = cur;
                if(cur.left != null)  queue.add(cur.left);
                if(cur.right != null)  queue.add(cur.right);
            }
            if (rightNode != null) res.add(rightNode.val);
        }
    return res;
    }
}
