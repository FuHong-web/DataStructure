package Revice2.erchashu;

import LeetCode.TreeNode;
import com.sun.jdi.ThreadReference;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/21 21:34
 * @desc:将有序数组转换为二叉搜索树
 */
public class p108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    private TreeNode build(int[] nums,int left,int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,left,mid - 1);
        root.right = build(nums,mid + 1,right);
        return root;
    }
}
