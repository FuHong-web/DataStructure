package LeetCode;

import java.util.Arrays;

/*合并两个有序数组*/
public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
