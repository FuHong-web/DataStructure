package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/22 20:01
 * @desc:力扣第111题
 */
public class Problem111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return 1;
        }
        int min_depth=Integer.MAX_VALUE;
        if (root.left!=null){
            min_depth=Math.min(minDepth(root.left),min_depth);
        }
        if (root.right!=null){
            min_depth=Math.min(minDepth(root.right),min_depth);
        }
        return min_depth+1;
    }
}

