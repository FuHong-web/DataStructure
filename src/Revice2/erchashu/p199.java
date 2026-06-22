package Revice2.erchashu;

import LeetCode.TreeNode;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/22 22:00
 * @desc:二叉树的右视图
 */
public class p199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        dfs(root,0,levelList);
        List<Integer> res = new ArrayList<>();
        for (List<Integer> integers : levelList) {
            res.add(integers.get(integers.size()-1));
        }
        return res;
    }
    private void dfs(TreeNode node,int levrl,List<List<Integer>> res) {
        if (node == null) return;;
        if (res.size() == levrl) res.add(new ArrayList<>());
        res.get(levrl).add(node.val);
        dfs(node.left,levrl+1,res);
        dfs(node.right,levrl+1,res);
    }
}
