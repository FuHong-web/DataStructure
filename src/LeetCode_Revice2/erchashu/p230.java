package LeetCode_Revice2.erchashu;

import LeetCode.TreeNode;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/21 22:30
 * @desc:二叉搜索树第k小的元素（）
 */
public class p230 {
    public int kthSmallest(TreeNode root,int k) {
        int cnt = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cnt++;
            if (cnt == k) {
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }
}
