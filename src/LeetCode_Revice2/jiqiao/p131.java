package LeetCode_Revice2.jiqiao;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/13 23:15
 * @desc:下一个排列
 */
public class p131 {
    public void nextPermutation(int[] nums) {
        int i;
        for ( i = nums.length-1;i>0;i--) {
            if (i+1<nums.length -1 && nums[i] < nums[i+1]) {
                for (int j = nums.length-1;j>i;j--) {
                    if (nums[i] < nums[j]) {
                        swap(nums,i,j);
                        break;
                    }
                }
                break;
            }
        }
        int left = i+1;
        int right = nums.length-1;
        while (left < right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    private void swap(int[] nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
