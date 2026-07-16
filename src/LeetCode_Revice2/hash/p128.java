package LeetCode_Revice2.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/3 21:54
 * @desc:先把所有数字放进集合，方便一秒判断某个数字存不存在
 * 遍历每一个数字，只找连续串的开头数字
 * 如果数字 x-1 不在集合里 → x 就是一段连续数字的第一个
 * 如果 x-1 在集合里，说明 x 只是中间数字，不用管，跳过
 * 找到开头后，往后一直数 x+1、x+2… 直到没有，记录这段有多长
 */
public class p128 {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int d : set) {
            if (!set.contains(d-1)) {
                int len = 0;
                while (set.contains(d+len)) {
                    len++;
                    maxLen = Math.max(len,maxLen);
                }
            }
        }
        return maxLen;
    }
}
