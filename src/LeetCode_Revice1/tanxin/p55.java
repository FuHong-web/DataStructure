package LeetCode_Revice1.tanxin;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/15 22:24
 * @desc:跳跃游戏
 * 我要到达最后一格
 * 从后往前找：谁能直接跳到我现在的目标？
 * 找到一个，立刻把目标改成它！
 */
public class p55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int index = nums.length;
        int target = index - 1;
        for (int i = index - 2;i >= 0; i--) {
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
