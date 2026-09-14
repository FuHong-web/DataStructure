package LeetCode_Revice5.shuzu;
/*除自身以外的数组乘积*/
public class P238 {
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] ans = new int[n];
        leftSum[0] = 1;
        rightSum[n-1] = 1;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i-1] * nums[i-1];
        }
        for(int i = n-2;i >= 0;i--){
            rightSum[i] = rightSum[i+1] * nums[i+1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = leftSum[i] * rightSum[i];
        }
        return ans;
    }
}
