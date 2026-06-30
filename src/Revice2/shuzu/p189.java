package Revice2.shuzu;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/25 22:14
 * @desc:轮换数组
 */
public class p189 {
    public void rotate (int[] nums,int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i+k) % n] = nums[i];
        }
        System.arraycopy(newArr,0,nums,0,n);
    }
}
