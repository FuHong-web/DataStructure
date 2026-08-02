package LeetCode_Revice3.zhan;

import java.util.Stack;

/*有效的括号*/
public class p20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top  = stack.pop();
                if(c==')' && top!= '(' || c == ']' && top != '[' || c== '}' && top !='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
