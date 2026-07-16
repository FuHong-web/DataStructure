package LeetCode_Revice1.erchashu;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/11 23:48
 * @desc:二叉树的直径
 */
public class p543 {
    int ans; // 全局变量：记录最大直径（节点数）

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;   // 初始化最小节点数为1
        depth(root);
        return ans - 1; // 最终答案要把节点数转成边数
    }

    // 递归函数：返回以root为根的子树的最大深度
    public int depth (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int L = depth(root.left);  // 左子树深度
        int R = depth(root.right); // 右子树深度

        // 核心：更新最大直径 = 左深度 + 右深度 + 当前节点
        ans = Math.max(ans, L + R + 1);

        // 返回当前子树的最大深度
        return Math.max(L, R) + 1;
    }
}
