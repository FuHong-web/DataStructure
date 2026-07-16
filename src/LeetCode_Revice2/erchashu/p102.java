package LeetCode_Revice2.erchashu;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/21 12:39
 * @desc:二叉树的层序遍历
 */
public class p102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0,res);
        return res;
    }
    public void dfs(TreeNode node,int level,List<List<Integer>> res){
        if (node == null) return;;
        if (res.size() == level) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        dfs(node.left,level+1,res);
        dfs(node.right,level+1,res);
    }
}
