package Revice2.shuangzhizhen;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/3 22:02
 * @desc:移动零
 */
public class p283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i=0;i<nums.length;i++) {
            while (nums[i]!=0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
