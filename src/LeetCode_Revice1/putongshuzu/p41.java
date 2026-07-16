package LeetCode_Revice1.putongshuzu;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/2 22:25
 * @desc:缺失的第一个正数
 */
public class p41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[i] !=nums[nums[i] - 1]) {
                swap(nums,i,nums[i] - 1);
            }
        }
        /*从头到尾检查一遍，谁没坐在自己的位置上，谁就是缺失的最小正整数！*/
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+ 1){
                return i + 1;
            }
        }
        return n + 1;
    }
    private void swap(int[] nums,int i ,int j ){
        int temp =nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
