package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/19 21:34
 * @desc:105. 从前序与中序遍历序列构造二叉树(递归)
 */
public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 递归终止：数组为空，返回空节点
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // 前序第一个元素就是根节点
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;

        // 在中序数组里找到根节点位置，分割左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }

        // ========== 左子树数组切割 ==========
        // 左子树前序：[1 , index] 长度=index
        int[] leftPre = new int[index];
        System.arraycopy(preorder, 1, leftPre, 0, index);

        // 左子树中序：[0 , index-1]
        int[] leftIn = new int[index];
        System.arraycopy(inorder, 0, leftIn, 0, index);

        root.left = buildTree(leftPre, leftIn);

        // ========== 右子树数组切割 ==========
        int rightLen = inorder.length - index - 1;
        // 右子树前序：[index+1 , 末尾]
        int[] rightPre = new int[rightLen];
        System.arraycopy(preorder, index + 1, rightPre, 0, rightLen);

        // 右子树中序：[index+1 , 末尾]
        int[] rightIn = new int[rightLen];
        System.arraycopy(inorder, index + 1, rightIn, 0, rightLen);

        root.right = buildTree(rightPre, rightIn);

        return root;
    }
}
