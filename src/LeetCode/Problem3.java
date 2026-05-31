package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2025/12/29 20:01
 * @desc:力扣第3题：无重复的最长子字符串
 */
public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int left=0;
        int right=0;
        int length=0;
        int maxlength=0;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                length++;
                if (length>maxlength){
                    maxlength=length;
                }
                right++;
            }
            else {
                while (set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                    length--;
                }
                set.add(s.charAt(right));
                length++;
                right++;
            }
        }
        return maxlength;
}
}
