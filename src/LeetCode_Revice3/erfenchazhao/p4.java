package LeetCode_Revice3.erfenchazhao;
/*两个有序数组的中位数*/
public class p4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int low = 0;
        int high = m;
        while (low<=high){
            int i= (low+high) / 2;
            int j = (m+n +1) -i;
            int left1 = (i==0) ? Integer.MIN_VALUE : nums1[i-1];
            int right1 = (i==m) ? Integer.MAX_VALUE : nums1[i];
            int left2 = (j==0) ? Integer.MIN_VALUE : nums2[j-1];
            int right2 = (i==n) ? Integer.MAX_VALUE : nums2[j];

            if(left1 <= right2 && left2 <= right1){
                if((m+n) % 2== 0){
                    return (Math.max(left1,left2)+Math.min(right1,right2));
                }else {
                    return Math.max(left1,left2);
                }
            } else if (left1 > right2) {
                high = i-1;
            }else {
                low = j+1;
            }
        }
        return 0.0;
    }
}
