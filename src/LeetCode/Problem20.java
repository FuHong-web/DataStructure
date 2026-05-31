package LeetCode;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/9 22:45
 * @desc:力扣第20题：有效的括号
 */
public class Problem20 {
    public boolean isValid(String s) {
        // 空字符串视为有效
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 左括号入栈
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 遇到右括号时，栈为空则直接无效（无左括号匹配）
                if (stack.isEmpty()) {
                    return false;
                }
                // 弹出栈顶左括号，判断是否与当前右括号匹配
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // 遍历结束后，栈必须为空（所有左括号都匹配完毕）
        return stack.isEmpty();
    }
}

