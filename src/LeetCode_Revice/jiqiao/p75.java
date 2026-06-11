package LeetCode_Revice.jiqiao;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/10 21:25
 * @desc:颜色分类
 * [0, p0-1] 全 0 、[p0, i-1] 全 1 、[p2+1, len-1] 全 2
 */
public class p75 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int p0 = 0;
        int i = 0;
        int p2 = len-1;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums,i,p0);
            }else if (nums[i] == 1) {
                i++;
            }else {
                swap(nums,i,p2);
            }
        }
    }
    private void swap(int[] nums,int left,int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
