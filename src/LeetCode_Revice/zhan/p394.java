package LeetCode_Revice.zhan;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/31 11:30
 * @desc:字符串解码：遇到 [ 就保存现场，遇到 ] 就解码还原。
 * 看到数字 → 算当前倍数
 * 看到字母 → 拼当前字符串
 * 看到 [ → 保存现场（把现在的东西存进栈）
 * 看到 ] → 还原现场（拿出来重复、拼接）
 */
public class p394 {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder curStr = new StringBuilder();
        int curNum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            } else if (c == '[') {
                strStack.push(curStr.toString());
                numStack.push(curNum);
                curStr = new StringBuilder();
                curNum = 0;
            } else if (c == ']') {
                int k = numStack.pop();
                String preStr = strStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < k; i++) {
                    temp.append(curStr);
                }
                curStr = new StringBuilder(preStr);
                curStr.append(temp);
            }else {
                curStr.append(c);
            }
        }
        return curStr.toString();
    }
}
