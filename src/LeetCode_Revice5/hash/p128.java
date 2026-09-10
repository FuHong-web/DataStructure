package LeetCode_Revice5.hash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*最长连续序列*/
public class p128 {
    public int maxLen(int[] nums){
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if(!set.contains(num-1)){
                int len = 0;
                while (set.contains(num+len)){
                    len++;
                    maxLen = Math.max(maxLen,num+len);
                }
            }
        }
        return maxLen;
    }
}
