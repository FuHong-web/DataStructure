package LeetCode_Revice2.tanxinsuanfa;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/27 23:39
 * @desc:跳跃游戏ii
 */
public class p45 {
    public int jump(int[] nums) {
        int target = nums.length - 1;
        int count = 0;
        while (target != 0) {
            for (int i = 0; i < target; i++) {
                if (i + nums[i] >= target) {
                    target = i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
