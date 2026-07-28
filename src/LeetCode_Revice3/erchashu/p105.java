package LeetCode_Revice3.erchashu;

import LeetCode.TreeNode;

/*从前序和中序遍历构造二叉树*/
public class p105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0;i < inorder.length;i++) {
            if (inorder[i] == preorder[i]) {
                index = i;
                break;
            }
        }
        int[] leftPre = new int[index];
        System.arraycopy(preorder,1,leftPre,0,index);
        int[] leftIn = new int[index];
        System.arraycopy(inorder,0,leftIn,0,index);
        root.left = buildTree(leftPre,leftIn);

        int rightLen = inorder.length - index -1;
        int[] rightPre = new int[rightLen];
        System.arraycopy(preorder,index+1,rightPre,0,rightLen);
        int[] rightIn = new int[rightLen];
        System.arraycopy(inorder,index+1,rightIn,0,rightLen);
        root.right = buildTree(rightPre,rightIn);
        return root;

    }
}
