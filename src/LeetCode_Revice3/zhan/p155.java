package LeetCode_Revice3.zhan;

import javax.print.DocFlavor;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Stack;

/*最小栈*/
public class p155 {
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack() {
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                if (stack.pop().equals(minStack.peek())) {
                    minStack.pop();
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
