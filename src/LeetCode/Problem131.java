package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*index 表示"当前要分割的位置"，即从字符串的哪个位置开始继续切割。*/
/**
 * @author: Yan Tong xue
 * @Created:2026/4/7 22:55
 * @desc:力扣第131题：分割回文串（回溯）
 */
public class Problem131 {

        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            dfs(s, 0, res, temp);
            return res;
        }

        public void dfs(String s, int index, List<List<String>> res, List<String> temp) {
            if (index == s.length()) {
                res.add(new ArrayList<>(temp));
                return;
            }

            // 从 index 开始，尝试所有可能的分割点
            for (int i = index; i < s.length(); i++) {
                if (isHW(s, index, i)) {
                    temp.add(s.substring(index, i + 1));//切割得到的是index-i
                    dfs(s, i + 1, res, temp);//因为 i 是当前分割的终点，下一个分割必须从 i+1 开始，不能重复使用字符。
                    temp.remove(temp.size() - 1);
                }
            }
        }

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

