package DifficultProblem;

import com.sun.tools.javac.Main;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/11 23:06
 * @desc:寻找两个正序数组的中位数
 */
public class P4 {
    public double finfMedainSortedArrays(int[] nums1,int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 0) {
            int left = find(nums1,0,nums2,0,n/2);
            int right = find(nums1,0,nums2,0,n/2+1);
            return (left+right) /2.0;
        }else {
            return find(nums1,0,nums2,0,n/2+1);
        }
    }
    public int find (int[] nums1,int i,int[] nums2,int j,int k) {
        if (nums1.length - i > nums2.length - j) {
            return find(nums2,j,nums1,i,k);
        }
        if (nums1.length == i) {
            return nums2[j + k -1];
        }
        if (k==1) {
            return Math.min(nums1[i],nums2[j]);
        }
        int idx1 = Math.min(nums1.length,i+k/2);
        int idx2 = j + k - k/2;
        if (nums1[idx1 - 1] < nums2[idx2 -1]) {
            return find(nums1,idx1,nums2,j,k-(idx1 - i));
        }else {
            return find(nums1,i,nums2,idx2,k-(idx2 - j));
        }
    }

}
