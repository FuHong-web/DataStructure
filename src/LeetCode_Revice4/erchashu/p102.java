package LeetCode_Revice4.erchashu;

import LeetCode.ListNode;
import LeetCode.TreeNode;

import javax.imageio.event.IIOWriteWarningListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/*二叉树的层序遍历*/
public class p102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root !=null) queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if(cur.left != null) queue.add(root.left);
                if(cur.right != null) queue.add(root.right);
            }
            res.add(temp);
        }
        return res;
    }
}