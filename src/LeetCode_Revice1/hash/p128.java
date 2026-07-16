package LeetCode_Revice1.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/2 22:56
 * @desc:最长连续子序列
 * 用 HashSet 存所有数字，方便快速查 “某个数字存在不存在”
 * 只从连续序列的起点开始查
 * 起点判断：没有比它小 1 的数字
 * 从起点一直往后数：num+1、num+2… 存在就长度 + 1
 * 记录最大长度
 */
public class p128 {
    public int longestConsecutive(int[] nums) {
        int max_len = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num-1)) {
                int len = 0;
                while (set.contains(num +len)) {
                    len++;
                    max_len = Math.max(max_len,len);
                }
            }
        }
        return max_len;
    }

}
