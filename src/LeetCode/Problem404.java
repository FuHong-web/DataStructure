package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/11/19 23:58
 * @desc:力扣第404题：左叶子之和
 */
public class Problem404 {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) { // 空节点
                return 0;
            }
            // 递归左右子树，收集左右子树中的「节点的左儿子是叶子」的叶子节点值之和
            int sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
            TreeNode left = root.left; // 当前节点的左儿子
            if (left != null && left.left == null && left.right == null) { // 当前节点的左儿子是叶子
                sum += left.val; // 累加节点值
            }

            return sum;

        }
    }

