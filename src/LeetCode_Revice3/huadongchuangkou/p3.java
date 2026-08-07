package LeetCode_Revice3.huadongchuangkou;

import java.util.HashSet;
import java.util.Set;

/*无重复字符的最长子串*/
public class p3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int right = 0;right<s.length();right++){
            char c= s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
