package LeetCode_Revice5.erchashu;

import LeetCode.TreeNode;

import java.util.Stack;

/*二叉搜索树第k小的元素*/
public class p230 {
    public int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        int cnt = 0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
                cur = stack.pop();
                cnt++;
                if(cnt == k){
                    return cur.val;
                }
                cur = cur.right;
            }
        return -1;
        }
}
