package LeetCode_Revice.jiqiao;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/10 22:07
 * @desc:下一个排列
 */
public class p31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = n - 1;
        while (k > 0 && nums[k-1] >= nums[k]) {
            k--;
        }
        if (k <= 0) {
            reverse(nums,0,n-1);
        }else {
            int t = n-1;
            while (nums[t] <= nums[k-1]){
                t--;
            }
            swap(nums,t,k-1);
            reverse(nums,k,n-1);
        }
    }
    private void reverse(int[] nums,int left,int right){
        while (left < right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
