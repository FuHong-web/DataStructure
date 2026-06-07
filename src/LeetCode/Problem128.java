package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/22 21:34
 * @desc:最长的连续序列（）
 */
public class Problem128 {
    public int longestConsecutive(int[] nums) {
        int max_len = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {//如果集合中，没有当前元素的前一个元素，就说明他是起始元素
                int len = 0;
                while (set.contains(num + len)) {
                    len++;
                    max_len = Math.max(max_len, len);
                }
            }
        }
        return max_len;
    }
}
