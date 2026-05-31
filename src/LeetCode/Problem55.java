package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/22 21:58
 * @desc:力扣第55题：跳跃游戏（贪心算法）
 */
public class Problem55 {
    public boolean canJump(int[] nums) {
        // 特殊情况：数组长度为1，已经在终点，直接返回true
        if (nums.length == 1) {
            return true;
        }
        int target = nums.length - 1;//把最后一个索引设置为目标值
        for (int i = nums.length - 2; i >= 0; i--) {//从倒数第二个索引开始遍历
            // 核心判断：当前位置i能跳到的最远位置 >= 目标位置
            if (nums[i] + i >= target) {
                target = i;
            }
            if (target == 0) {
                return true;
            }
        }
        return false;
    }
}
