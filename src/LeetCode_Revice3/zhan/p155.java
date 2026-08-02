package LeetCode_Revice3.zhan;

import javax.print.DocFlavor;
import java.util.Stack;

/*最小栈*/
public class p155 {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        public MinStack(){
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        public void push(int value) {
            stack.push(value);
            if (minStack.isEmpty() || value <= minStack.peek()){
                minStack.push(value);
            }
        }
        public void pop(){
            if(stack.pop().equals(minStack.peek())){
                minStack.pop();
            }
        }
        public int top(){
            return stack.peek();
        }
        public int getMin(){
            return minStack.peek();
        }
    }
}
