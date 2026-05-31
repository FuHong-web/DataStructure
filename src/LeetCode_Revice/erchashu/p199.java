package LeetCode_Revice.erchashu;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/26 22:43
 * @desc:二叉树右视图
 */
public class p199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode rightNode = null;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    rightNode = cur;
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            if (rightNode != null) {
                res.add(rightNode.val);
            }
        }
        return res;
    }
}
