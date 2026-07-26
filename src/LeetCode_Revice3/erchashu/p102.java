package LeetCode_Revice3.erchashu;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*二叉树的层序遍历*/
public class p102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        if (root!=null) nodes.add(root);
        while (!nodes.isEmpty()) {
            int nodesLen = nodes.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0;i<nodesLen;i++) {
                TreeNode node = nodes.poll();
                temp.add(node.val);
                if (node.left!= null) nodes.add(node.left);
                if (node.right!=null) nodes.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
