package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/6 23:35
 * @desc:力扣第199题：二叉树的右视图（辅助队列）
 */
public class Problem199 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int levelSize = q.size();
                TreeNode rightNode = null;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode cur = q.poll();
                    if (cur != null) {
                        rightNode = cur;
                        q.offer(cur.left);
                        q.offer(cur.right);
                    }
                }
                if (rightNode != null) {
                    res.add(rightNode.val);
                }
            }
            return res;
        }
}
