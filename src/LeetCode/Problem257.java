package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2025/11/12 22:59
 * @desc:力扣第257题:二叉树的所有路径
 */
public class Problem257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;
    }

    // 把 String 改成 StringBuilder 更快，见右边的【Java 写法二】
    private void dfs(TreeNode node, String path, List<String> ans) {
        if (node == null) {
            return;
        }
        path += node.val;
        if (node.left == null && node.right == null) { // 叶子节点
            ans.add(path);
            return;
        }
        path += "->";
        dfs(node.left, path, ans);
        dfs(node.right, path, ans);
    }

}
