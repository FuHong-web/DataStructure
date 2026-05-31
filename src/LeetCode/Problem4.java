package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/26 20:22
 * @desc:寻找两个正序数组的中位数（二分递归）
 */
public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;  // 总长度
        if (n % 2 == 0) {  // 偶数个元素
            int left = find(nums1, 0, nums2, 0, n / 2);    // 找第 n/2 小
            int right = find(nums1, 0, nums2, 0, n / 2 + 1); // 找第 n/2+1 小
            return (left + right) / 2.0;  // 平均值
        } else {  // 奇数个元素
            return find(nums1, 0, nums2, 0, n / 2 + 1); // 找正中间那个
        }
    }
    private int find(int nums1[], int i ,int[] nums2 , int j, int k) {
        if (nums1.length - i > nums2.length - j) {
            return find(nums2 , j ,nums1 , i , k);
        }
        if (nums1.length == i) {
            return nums2[j + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i],nums2[j]);
        }
        int idx1 = Math.min(nums1.length,i + k / 2);
        int idx2 = j + k - k / 2;
        if (nums1[idx1 - 1] < nums2[idx2 - 1]) {
            return find(nums1,idx1,nums2,j,k - (idx1 - i));
        }else {
            return find(nums1,i,nums2,idx2,k - (idx2 - j));
        }
    }
}
