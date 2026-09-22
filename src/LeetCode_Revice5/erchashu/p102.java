package LeetCode_Revice5.erchashu;

import LeetCode.ListNode;
import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*二叉树的·层序遍历*/
public class p102 {
    private List<List<Integer>> cengxu(TreeNode root){
        List<List<Integer>> res= new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int queueLen = queue.size();
            for (int i = 0; i < queueLen; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            res.add(temp);
        }
        return res;

    }
}
