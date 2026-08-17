package LeetCode_Revice4.shuzu;
/*轮转数组*/
public class p189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        System.arraycopy(temp,0,nums,0,n);
    }
}
