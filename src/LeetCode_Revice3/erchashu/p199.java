package LeetCode_Revice3.erchashu;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*二叉树的右视图*/
public class p199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int quelen = queue.size();
            TreeNode rightNode = null;
            for (int i= 0;i<quelen;i++) {
                TreeNode cur = queue.poll();
                if (cur!=null) {
                    rightNode = cur;
                    if (cur.left!=null) queue.add(cur.left);
                    if (cur.right!= null) queue.add(cur.right);
                }
            }
            if (rightNode!=null) res.add(rightNode.val);
        }
        return res;
    }
}
