package LeetCode_Revice.shuangzhizhen;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/10 23:04
 * @desc:移动0
 */
public class p283 {
    /*
    * 工作原理：
    指针 i（快指针）：逐个遍历数组中的每个元素
    指针 j（慢指针）：始终指向下一个非零元素应该存放的位置
    当 nums[i] 不为 0 时，将其复制到 nums[j]，然后 j++
    当 nums[i] 为 0 时，跳过，j 不动
    * */
    private void moveZero(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int m = j;m < nums.length;m++) {
            nums[m] = 0;
        }
    }
}
