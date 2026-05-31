package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/26 19:52
 * @desc:236.二叉树最近的公共祖先（深度优先搜索+递归）
 */
public class Problem236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        // 分别找到根到p、根到q的路径
        dfs(root, p, new ArrayList<>(), pathP);
        dfs(root, q, new ArrayList<>(), pathQ);

        // 找两条路径最后一个相同的节点
        TreeNode res = null;
        int minLen = Math.min(pathP.size(), pathQ.size());
        for (int i = 0; i < minLen; i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                res = pathP.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    private void dfs(TreeNode node, TreeNode target, List<TreeNode> path, List<TreeNode> result) {
        if (node == null || !result.isEmpty()) {
            return; // 已找到就提前返回
        }
        path.add(node);
        if (node == target) {
            result.addAll(path); // 找到目标，保存路径
            return;
        }
        dfs(node.left, target, path, result);
        dfs(node.right, target, path, result);
        path.remove(path.size() - 1); // 回溯
    }
}
