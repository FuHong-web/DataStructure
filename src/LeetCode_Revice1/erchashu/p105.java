package LeetCode_Revice1.erchashu;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/27 23:55
 * @desc:利用前序遍历和中序遍历构建二叉树
 * 用前序找根
 * 用中序分左右
 * 把左右子树重复上面两步（递归）
 */
public class p105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // ===================== 1. 递归终止条件 =====================
        // 如果数组空了，说明没有节点，返回 null
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // ===================== 2. 找根节点 =====================
        // 前序遍历第一个数 = 根节点！这是铁律
        TreeNode root = new TreeNode(preorder[0]);

        // index 用来记录：根节点在【中序数组】里的位置
        int index = 0;

        // 遍历中序数组，找到根节点在哪里
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;  // 找到了！记录位置
                break;
            }
        }

        // ===================== 3. 切割：左子树的数组 =====================
        // 左子树有多少个节点？答案：index 个（中序里根节点左边的数量）
        int[] leftPre = new int[index];
        // 复制：前序数组从 1 开始，拿 index 个 → 左子树的前序
        System.arraycopy(preorder, 1, leftPre, 0, index);

        int[] leftIn = new int[index];
        // 复制：中序数组从 0 开始，拿 index 个 → 左子树的中序
        System.arraycopy(inorder, 0, leftIn, 0, index);

        // 递归构造左子树，挂到根节点左边
        root.left = buildTree(leftPre, leftIn);

        // ===================== 4. 切割：右子树的数组 =====================
        // 右子树长度 = 总长度 - 左子树长度 - 根节点自己
        int rightLen = inorder.length - index - 1;

        int[] rightPre = new int[rightLen];
        // 前序数组从 index+1 开始，拿右子树的所有节点
        System.arraycopy(preorder, index + 1, rightPre, 0, rightLen);

        int[] rightIn = new int[rightLen];
        // 中序数组从 index+1 开始，拿右子树的所有节点
        System.arraycopy(inorder, index + 1, rightIn, 0, rightLen);

        // 递归构造右子树，挂到根节点右边
        root.right = buildTree(rightPre, rightIn);

        // 最后返回构造好的根节点
        return root;
    }
}
