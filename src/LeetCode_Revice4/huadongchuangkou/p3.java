package LeetCode_Revice4.huadongchuangkou;

import java.util.HashSet;
import java.util.Set;

/*无重复字符的最长子串*/
public class p3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int right =0;right < s.length();right++){
            char r = s.charAt(right);
            while (set.contains(r)){
                set.remove(s.charAt(left++));
            }
            set.add(r);
            max = Math.max(max,right - left +1);
        }
        return max;
    }
}
