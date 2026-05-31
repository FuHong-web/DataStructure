package LeetCode_Revice.zhan;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/31 11:21
 * @desc:最小栈
 */
public class p155 {
    class MinStack {
        private Stack<Integer> stack;    // 正常存数据
        private Stack<Integer> minStack; // 专门存最小值

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        // 入栈：同时维护最小栈
        public void push(int val) {
            stack.push(val);
            // ✅ 关键：<= 才能处理重复最小值
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        // 出栈：如果栈顶 == 最小值，最小栈也要出栈
        public void pop() {
            // 必须用 equals 比较 Integer！
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }

        // 看栈顶（不删除）
        public int top() {
            return stack.peek();
        }

        // 获取最小值（O(1)）
        public int getMin() {
            return minStack.peek();
        }
    }
}
