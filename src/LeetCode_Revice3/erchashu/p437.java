package LeetCode_Revice3.erchashu;

import LeetCode.TreeNode;

/*路径总和*/
public class p437
{
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int start = dfs(root,0,targetSum);
        int leftLen = pathSum(root.left,targetSum);
        int rihtLen = pathSum(root.right,targetSum);
        return start+leftLen+rihtLen;
    }
    private int dfs(TreeNode node,int curSum,int targetSum) {
        if (node == null) return 0;
        int count = 0;
        if(curSum == targetSum) count+=1;
        count+=dfs(node.left,curSum,targetSum);
        count+=dfs(node.right,curSum,targetSum);
        return count;
    }
}
