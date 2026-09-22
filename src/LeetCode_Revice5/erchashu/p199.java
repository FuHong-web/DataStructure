package LeetCode_Revice5.erchashu;

import LeetCode.ListNode;
import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*二叉树的右视图*/
public class p199 {
    public List<Integer> rightSideView(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res= new ArrayList<>();
        if(root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            TreeNode rightNode = null;
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                rightNode = cur;
                if(rightNode.left != null)  queue.add(rightNode.left);
                if(rightNode.right != null)  queue.add(rightNode.right);
            }
            if(rightNode != null) {
                res.add(rightNode.val);
            }
        }
        return res;
    }
}
