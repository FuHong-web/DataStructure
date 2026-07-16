package LeetCode_Revice2.tanxinsuanfa;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/27 23:23
 * @desc:跳跃游戏
 */
public class p55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int indx = nums.length;
        int target = indx -1;
        for (int i = indx -2;i>= 0;i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
            if (target == 0) {
                return true;
            }
        }
        return false;
    }
}
