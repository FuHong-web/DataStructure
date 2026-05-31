package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/22 19:23
 * @desc:力扣第104题
 */
public class Problem104 {
    public static void main(String[] args) {

    }
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }else {
            int leftmax=maxDepth(root.left);
            int rightmax=maxDepth(root.right);
            return Math.max(leftmax,rightmax);
        }
    }
}
