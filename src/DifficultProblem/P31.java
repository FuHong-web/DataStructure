package DifficultProblem;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/10 22:17
 * @desc:下一个排列
 */
public class P31 {
        public void  nextPermutation(int[] nums) {
            int m = nums.length;
            int  k = m -1;
            while (k>0 && nums[k-1] >= nums[k]) {
                k--;
            }
            if (k < 0) {
                reverse(nums,0,m-1);
            }else {
                int t = m-1;
                while (nums[t] <= nums[k-1]) {
                    swap(nums,k-1,t);
                    reverse(nums,k,m-1);
                }
            }
        }
        private void reverse (int[] nums,int left,int right) {
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
