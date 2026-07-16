package DifficultProblem;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/10 22:17
 * @desc:下一个排列
 */
public class P31 {
    public void nextPermutation(int[] nums) {
       int i;
       for (i = nums.length -1;i >= 0;i--) {
           if (i + 1< nums.length && nums[i] < nums[i+1]) {
               for (int j = nums.length-1;j>i;j--) {
                   if (nums[j] > nums[i]) {
                       swap(nums,i,j);
                       break;
                   }
               }
               break;
           }
       }
       int left = i + 1;
       int right = nums.length -1;
       while (left< right) {
           swap(nums,left,right);
            left++;
            right--;
       }

    }
    private void swap (int[] nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
