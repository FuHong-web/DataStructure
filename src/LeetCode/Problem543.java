package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/20 9:13
 * @desc:力扣第543题：二叉树的直径（深度遍历搜索）
 *
 * L：左子树往下最长链长度
 * R：右子树往下最长链长度
 * 一棵树的高度 = 只能选择【左右其中更长的那一条支路】继续向上汇报！
 *
 * L+R+1：左右两条分叉连起来，形成一条横线（候选直径）
 * max(L,R)+1：只走更长的一条分叉，一条竖线（子树高度）
 */
public class Problem543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans=1; // ① 初始化全局变量
        // ② 调用递归（depth 内部会不断修改 ans）
        // ④ 读取最终的 ans(是遍历的结点数，最终要减一)
        depth(root);
        return ans-1;
    }
    public int depth(TreeNode node){//用深度算直径
        if (node==null){
            return 0;
        }
        int L=depth(node.left);
        int R=depth(node.right);
        ans=Math.max(ans,L+R+1);
        return Math.max(L,R)+1;
    }
}
