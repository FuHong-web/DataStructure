package LeetCode_Revice.huisu;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.StreamSupport;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/9 21:32
 * @desc:分割回文串
 *
 * 四、现在你彻底懂了：
 * index = 从哪开始切（固定当前层）
 * i = 切到哪去（不断往后试）
 * 五、最直观的比喻
 * 你要切一根香肠：
 * index = 你上一刀切完的位置
 * i = 你这一刀想切到哪里
 * 每切一段成功的，下一刀就从 i+1 开始
 * 六、最核心的两句话（背会）
 * index 是递归传下去的，代表 “下一次从哪切”
 * i 是当前层循环的，代表 “这次能切到哪”
 */
public class p131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Stack<String> temp = new Stack<>();
        dfs(s,0,res,temp);
        return res;
    }
    private void dfs(String s, int index, List<List<String>> res, Stack<String> temp) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index;i< s.length();i++) {
            if (isHw(s,index,i)) {
                temp.push(s.substring(index,i+1));
                dfs(s,i+1,res,temp);
                temp.pop();
            }
        }
    }
    private boolean isHw(String s,int left,int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
