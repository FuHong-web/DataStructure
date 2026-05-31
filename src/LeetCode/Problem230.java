package LeetCode;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/29 11:10
 * @desc:力扣第230题：二叉搜索树的第k小的元素（迭代遍历）越小的数越在左边，我要先找到最小的那个
 * 先找到最小的数（最左）
 * 从小到大一个一个数
 * 数到第 k 个，直接返回答案
 * 一路向左走到头
 * 回头一步，数一个数
 * 数到 k 就返回
 */
public class Problem230 {
    public int kthSmallest(TreeNode root, int k) {
        int cnt = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // 一直向左走，将左子节点入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 弹出栈顶节点（中序遍历的当前节点）
            cur = stack.pop();
            cnt++;

            // 找到第k小的元素
            if (cnt == k) {
                return cur.val;
            }

            // 转向右子树继续遍历
            cur = cur.right;
        }

        return -1; // 如果k超出范围，返回-1
    }
}