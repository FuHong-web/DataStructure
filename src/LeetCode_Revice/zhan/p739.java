package LeetCode_Revice.zhan;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/31 12:09
 * @desc: 每日最小温度
 *
 * 用栈存下标，从后往前 / 从前往后找第一个比自己大的数，用 “单调递减栈”
 * —— 这就是单调栈最经典的用法：找下一个更大元素
 */
public class p739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
