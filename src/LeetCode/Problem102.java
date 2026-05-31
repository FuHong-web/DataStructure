package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/18 18:13
 * @desc:力扣第102题:二叉树的层序遍历（深度遍历）
 */
public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){//如果队列不为空
            int queueLen=queue.size();//记录当前队列的大小==当前层的节点数
            List<Integer> temp=new ArrayList<>();//临时数组
            for (int i=0;i<queueLen;i++){
                TreeNode node=queue.poll();//把队列的元素弹出来
                temp.add(node.val);//把从队列弹出的结点的值加临时数组
                if (node.left!=null){
                    //如果当前弹出的结点左子节点不为空
                    queue.add(node.left);//
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
            return res;
    }
}
