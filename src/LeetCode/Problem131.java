package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/7 22:55
 * @desc:力扣第131题：分割回文串（回溯）
 */
public class Problem131 {
        public List<List<String>> partition(String s) {
            // 1. 必须初始化！！
            List<List<String>> res = new ArrayList<>();
            Stack<String> temp = new Stack<>();
            dfs(s, 0, res, temp);
            return res;
        }

        // 回溯：index 是当前开始分割的位置
        public void dfs(String s, int index, List<List<String>> res, Stack<String> temp) {
            // 终止条件：分割到末尾
            if (index == s.length()) {
                // 2. 必须 new 一个新列表存入结果！！不能直接存 temp
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = index; i < s.length(); i++) {
                // 判断 s[index...i] 是否回文
                if (isHW(s, index, i)) {
                    // 3. substring 正确写法
                    temp.push(s.substring(index, i + 1));
                    dfs(s, i + 1, res, temp);
                    temp.pop(); // 回溯
                }
            }
        }

        // 判断回文
        public boolean isHW(String s, int left, int right) {
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
