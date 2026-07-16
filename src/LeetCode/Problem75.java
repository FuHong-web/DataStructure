package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/12 23:07
 * @desc:力扣第75题：颜色的分类（三指针）
 */
public class Problem75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int cur = 0;
        for (int i = 0;i < n;i++) {
            if (nums[i] == 0) {
                swap(nums,i,cur);
                cur++;
            }
        }
        for (int i = cur;i < n;i++) {
            if (nums[i] == 1) {
                 swap(nums,i,cur);
                 cur++;
            }
        }
    }
    private void swap(int[] nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
