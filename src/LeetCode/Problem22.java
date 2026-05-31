package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/21 22:15
 * @desc:力扣第22题：括号生成（回溯+剪枝）
 */
public class Problem22 {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        dfs(n,0,0,temp,res);
        return res;
    }

    /*
    * n：需要生成的括号对数

    left：已使用的左括号数量

    right：已使用的右括号数量

    temp：当前正在构建的括号组合

    res：存储所有有效结果的列表
    * */
    public void dfs(int n,int left,int right,StringBuilder temp,List<String> res){
        if (left==n&&right==n){
            // 左右括号都用完，得到一个有效组合
            res.add(temp.toString());
            return;
        }
        if (left<n){// 还有左括号可用
            temp.append("(");// 添加左括号
            dfs(n,left+1,right,temp,res);// 递归继续构建
            temp.deleteCharAt(temp.length()-1);// 回溯：删除刚添加的左括号
        }
        if (right<left){// 右括号数量必须小于左括号数量
            temp.append(")");
            dfs(n,left,right+1,temp,res);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}

