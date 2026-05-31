package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/12 23:07
 * @desc:力扣第75题：颜色的分类（三指针）
 */
public class Problem75 {
    public void sortColors(int[] nums) {
        int len=nums.length;
        if (len<2){
            return;
        }
        int p0 = 0;
        int i = 0;
        int p2 = len-1;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums,i,p0);
                p0++;
                i++;
            }else if (nums[i] == 1) {
                i++;
            }else {
                swap(nums,i,p2);
                p2--;
            }
        }
    }
    private void swap(int[] nums,int index1,int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
