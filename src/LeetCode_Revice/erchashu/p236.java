package LeetCode_Revice.erchashu;

import LeetCode.TreeNode;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/29 21:31
 * @desc:二叉树的公共祖先
 */
public class p236 {
    public TreeNode lowerCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        List<TreeNode> pathP =new ArrayList<>();
        List<TreeNode> pathQ =new ArrayList<>();
        dfs(root,p,new ArrayList<>(),pathP);
        dfs(root,q,new ArrayList<>(),pathQ);

        TreeNode res = null;
        int minLen = Math.min(pathP.size(),pathQ.size());
        for (int i = 0; i < minLen; i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                res = pathP.get(i);
            }else {
                break;
            }
        }
        return res;
    }
        private void dfs(TreeNode node, TreeNode target, List<TreeNode> path,List<TreeNode> result) {
            if (node == null || !result.isEmpty()) {
                return;
            }
            path.add(node);
            if (node == target) {
                result.addAll(path);
                return;
            }
            dfs(node.left,target,path,result);
            dfs(node.right,target,path,result);
            path.remove(path.size() -1);
        }
}
