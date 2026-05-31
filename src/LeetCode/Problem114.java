package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/15 21:41
 * @desc:力扣第114题;二叉树展开为链表（递归递归）
 */
public class Problem114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = temp;
    }
}
