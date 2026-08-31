package LeetCode_Revice4.erchashu;

import LeetCode.TreeNode;

/*路径总和iii*/
public class p437 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int rootVal = dfs(root,targetSum,0);
        int left = pathSum(root.left,targetSum);
        int right = pathSum(root.right,targetSum);
        return left+right+rootVal;
    }
    //dfs:是找以node为根节点的满足路径和的路径数
    private int dfs(TreeNode node,int targetSum,long curSum){
        if(node == null) return 0;
        int count  = 0;
        curSum += node.val;
        if(curSum == targetSum){
            count++;
        }
        count+=dfs(node.left,targetSum,curSum);
        count+=dfs(node.right,targetSum,curSum);
        return count;
    }
    }

