package LeetCode_Revice3.dongtaiguihua;

import java.util.Stack;
//用栈匹配所有有效的括号对，标记它们的位置，然后找最长连续被标记的区间
/*最长得有效括号*/
public class p32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] mark = new boolean[s.length()];
        for(int i = 0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                if (!stack.isEmpty()) {
                    int j = stack.pop();
                    mark[i] = true;
                    mark[j] = true;
                }
            }
        }
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0;i< maxLen;i++) {
            if (mark[i] == true) {
                curLen+=1;
                maxLen =Math.max(curLen,maxLen);
            }else {
                curLen  = 0;
            }
        }
        return maxLen;
    }
}
