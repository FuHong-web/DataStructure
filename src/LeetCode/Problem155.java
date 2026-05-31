package LeetCode;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/21 22:45
 * @desc:力扣第155题：最小栈
 * 听不懂看这个https://www.bilibili.com/video/BV15X4y177cM?t=578.1
 */
public class Problem155 {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        public MinStack() {
            stack=new Stack<>();
            min_stack=new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (min_stack.isEmpty()||val<min_stack.peek()){
                min_stack.push(val);
            }
        }

        public void pop() {
            if (stack.pop().equals(min_stack.peek())){
                min_stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }
}
