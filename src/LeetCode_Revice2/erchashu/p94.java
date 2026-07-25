package LeetCode_Revice2.erchashu;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/17 0:30
 * @desc:二叉树的中序遍历
 */
public class p94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 定义内部递归逻辑
        dfs(root, res);
        return res;
    }

    // 内嵌递归抽取，整体仍为一个代码块，无多余外层方法
    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
