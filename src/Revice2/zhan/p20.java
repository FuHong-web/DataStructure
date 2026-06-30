package Revice2.zhan;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/25 22:31
 * @desc:有效的括号
 *
 */
public class p20 {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    char top = stack.pop();
                    if ((c == ')' && top != '(' )|| (c == '}' && top != '{' )|| (c == ']' && c != '[')) return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
