package LeetCode_Revice3.shuzu;
/*轮转数组*/
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
