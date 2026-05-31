package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/11/12 23:01
 * @desc:
 */
public class TreeNode {

     public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

