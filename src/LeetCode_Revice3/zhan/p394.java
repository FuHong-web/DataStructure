package LeetCode_Revice3.zhan;
/*
*
*
* 变量	          作用
numStack	存放 [ 前面的数字（字符串需要重复多少次）
strStack	存放 [ 前面已经拼接好的旧字符串
curStr	   正在收集当前括号内部的字母
curNum	    正在解析当前括号前面的倍数数字（支持多位数，比如12[ab]）
整体核心逻辑：
遇到 [ = 存档（把当前字符串、数字压入栈，清空临时变量去解析括号里面内容）
遇到 ] = 解封（取出存档的旧字符串 + 次数，把括号内字母重复拼接，合并成新字符串继续往外解析）
* */
import java.util.Stack;

/*字符串解码*/
public class p394 {
    public String decodeString(String s){
        Stack<String> strStack  = new Stack<>();
        Stack<Integer> numStack  = new Stack<>();
        StringBuffer curStr = new StringBuffer();
        int curNum = 0;
        for(char c : s.toCharArray()){
            if (Character.isDigit(c)){
                curNum = curNum *10+(c-'0');
            }else if(c == '['){
                strStack.push(curStr.toString());
                numStack.push(curNum);
                curStr = new StringBuffer();
                curNum = 0;
            }else if(c == ']'){
                String preStr = strStack.pop();
                int k = numStack.pop();
                StringBuffer temp = new StringBuffer();
                for(int i =0;i<k;i++){
                    temp.append(curStr);
                }
                curStr = new StringBuffer(preStr);
                curStr.append(temp);
            }else {
                curStr.append(c);
            }
        }
        return curStr.toString();
    }
}
