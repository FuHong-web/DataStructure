package LeetCode_Revice2.zhan;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/25 23:02
 * @desc:每日温度
 */
public class p739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 当前温度 > 栈顶下标对应的温度
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                // index那天要等 i-index 天升温
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
