package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/20 9:13
 * @desc:力扣第543题：二叉树的直径（深度遍历搜索）
 */
public class Problem543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans=1; // ① 初始化全局变量
        // ② 调用递归（depth 内部会不断修改 ans）
        // ④ 读取最终的 ans
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
