package LeetCode;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/11 0:01
 * @desc:力扣第739题：每日最高温度
 */
public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            // 注意：这里用 peek() 查看栈顶，而不是直接 pop()
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();  // 只pop一次
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
