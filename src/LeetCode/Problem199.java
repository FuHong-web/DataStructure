package LeetCode;
/*
* 遍历本层每一个节点：
- 只要节点不为 null，就更新`rightNode`为当前节点；**遍历结束后 rightNode 就是本层最右侧节点**
* */
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
            List<Integer> res= new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if(root != null) queue.add(root);
            while (!queue.isEmpty()){
                int len = queue.size();
                TreeNode rightNode = null;
                for (int i = 0; i < len; i++) {
                    TreeNode cur = queue.poll();
                    rightNode = cur;
                    if(cur!=null){
                    if(cur.left!= null) queue.add(cur.left);
                    if(cur.right!= null) queue.add(cur.right);
                }
                }
                if(rightNode!=null){
                    res.add(rightNode.val);
                }
            }
            return res;
        }
}
