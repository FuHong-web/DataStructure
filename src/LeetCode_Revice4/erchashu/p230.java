package LeetCode_Revice4.erchashu;

import LeetCode.TreeNode;

import java.util.Stack;
//cur 指针负责向右子树，栈负责保存祖先节点；只要任意一个还有东西，就不能停止遍历
/*二叉搜索树第k小的元素*/
public class p230 {
    public int kthSmallest(TreeNode root, int k) {
        int cnt = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cnt++;
            if(cnt == k){
                return cur.val;
            }
            stack.push(cur.right);
        }
        return -1;
    }
}


