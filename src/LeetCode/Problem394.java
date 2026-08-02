package LeetCode;

import java.awt.*;
import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/26 21:51
 * @desc:字符串编码（栈）
 */
public class Problem394 {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder curStr = new StringBuilder();
        int curNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            } else if (c == '[') {
                // 遇到左括号：保存当前字符串和数字
                strStack.push(curStr.toString());
                numStack.push(curNum);
                // 重置
                curStr = new StringBuilder();
                curNum = 0;
            } else if (c == ']') {
                // 弹出数字和之前保存的字符串
                int k = numStack.pop();
                String prevStr = strStack.pop();
                // 把当前字符串重复 k 次
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < k; i++) {
                    tmp.append(curStr);
                }
                // ✅ 关键：之前的字符串 + 新重复的字符串
                curStr = new StringBuilder(prevStr);
                curStr.append(tmp);
            }
            else {
                // 普通字母
                curStr.append(c);
            }
        }

        return curStr.toString();
    }
}
