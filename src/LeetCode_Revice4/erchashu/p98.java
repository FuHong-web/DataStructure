package LeetCode_Revice4.erchashu;

import LeetCode.TreeNode;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;

/*验证二叉搜索树*/
public class p98 {
    public boolean isValidBST(TreeNode root) {
        return isCche(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isCche(TreeNode node,long lower,long up){
        if(node == null) {
            return true;
        }
        if(node.val < lower || node.val > up){
            return false;
        }
        return isCche(node.left,lower,node.val) && isCche(node.right, node.val,up);
    }
}
