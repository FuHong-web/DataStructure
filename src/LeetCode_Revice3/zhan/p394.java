package LeetCode_Revice3.zhan;
/*
1. 压栈直到遇到`']'`
2. 弹出栈直到遇到`'['`
3. 弹栈直到栈顶不为数字


1. **碰到数字：收集数字到 curNum（支持多位数比如 10 [ab]）**
2. **碰到 `[`：【保存现场】**
把当前 curStr、curNum 压入两个栈；清空 curStr、curNum，curStr 准备接收括号里面的内容。

>
> 栈 = 存档，保存括号外面的数据。

3. **碰到字母：直接加到 curStr（curStr 存当前括号内的文字）**
4. **碰到 `]`：【恢复现场，做重复拼接】**
从栈取出存档的旧字符串 preStr，取出重复次数 k；
把 curStr（括号内内容）重复 k 次，拼回 preStr，赋值给 curStr。
* */
import java.util.Stack;

/*字符串解码*/
public class p394 {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuffer curStr = new StringBuffer();
        int curNum = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                curNum = curNum * 10 + c - '0';
            }else if(c == '['){
                strStack.push(curStr.toString());
                numStack.push(curNum);
                curStr = new StringBuffer();
                curNum = 0;
            }else if (c == ']'){
                String preStr = strStack.pop();
                int preNum = numStack.pop();
                StringBuffer temp = new StringBuffer();
                for (int i = 0; i < preNum; i++) {
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
