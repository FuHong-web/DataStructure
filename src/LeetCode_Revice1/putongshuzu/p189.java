package LeetCode_Revice1.putongshuzu;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/1 23:34
 * @desc:旋转数组
 */
public class p189 {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] newarr = new int[n];
        for (int i=0;i<n;i++){
            newarr[(i+k)%n]=nums[i];
        }
        System.arraycopy(newarr,0,nums,0,n);
    }
}
