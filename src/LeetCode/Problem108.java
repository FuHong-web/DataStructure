package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/26 22:16
 * @desc:力扣第108题： 将有序数组转换为二叉搜索树(二分查找法)
 */
public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    private TreeNode build(int[] nums,int left,int right){
        if (left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=build(nums,left,mid-1);
        root.right=build(nums,mid+1,right);
        return root;
    }

}
