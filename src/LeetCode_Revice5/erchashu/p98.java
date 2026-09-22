package LeetCode_Revice5.erchashu;

import LeetCode.TreeNode;

/*验证二叉搜索树*/
public class p98
{
public boolean isValidBST(TreeNode root){
    return ische(root,Long.MIN_VALUE,Long.MAX_VALUE);
}
private boolean ische(TreeNode node,long lower,long upper){
    if(node == null) return true;
    if(node.val < lower || node.val > upper) return false;
    return ische(node.left,lower,node.val) && ische(node.right,node.val,upper);
}

}
