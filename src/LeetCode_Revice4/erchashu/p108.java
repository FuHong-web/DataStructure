package LeetCode_Revice4.erchashu;

import LeetCode.ListNode;
import LeetCode.TreeNode;

/*讲有序数组转换为尾插搜索树*/
public class p108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    private TreeNode build(int[] nums,int left,int right) {
        if(left > right) return null;
        int mid = left + (right-left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        build(nums,left,mid-1);
        build(nums,mid+1,right);
        return root;
    }
}
