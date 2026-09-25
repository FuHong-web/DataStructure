package LeetCode_Revice3.hash;

import java.util.HashSet;
import java.util.Set;

/*最长连续序列*/
public class p128 {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if(!set.contains(num-1)){
                int len = 0;
                while (set.contains(num+len)){
                    len++;
                    maxLen = Math.max(maxLen,len);
                }
            }
        }
        return maxLen;
    }
}
