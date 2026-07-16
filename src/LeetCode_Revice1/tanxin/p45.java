package LeetCode_Revice1.tanxin;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/15 22:45
 * @desc:跳跃游戏ii
 *把每一跳能覆盖的范围当成一个窗口 [left, right]
 * 在窗口里全局选能跳最远的位置（局部最优）
 * 直接跳到最远位置，步数最少（全局最优）
 * 窗口不断右移，直到覆盖终点
 *  for 循环：在当前范围内找最远能跳到哪
 * （还没跳，只是看）
 * 2. 循环结束后：才真正跳一步，更新范围
 * （看完了，跳！）
 */
public class p45 {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int minJump = 0;

        // 只要还没跳到最后一格，就继续
        while (right < nums.length - 1) {
            int farthest = 0;

            // 在当前能到达的范围 [left ~ right] 里找最远能跳到哪
            for (int i = left; i <= right; i++) {
                farthest = Math.max(nums[i] + i, farthest);
            }

            // 一次跳跃完成，更新范围
            left = right + 1;   // 下一次的起点
            right = farthest;   // 下一次能到的最远点
            minJump++;          // 步数 +1
        }

        return minJump;
    }
}
