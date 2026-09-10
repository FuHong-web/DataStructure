package LeetCode_Revice5.huadongchuangkou;

import java.util.HashSet;
import java.util.Set;

/*无重复字符得最长子串*/
public class p3 {
    public int maxLen(String s){
        Set<Character> set= new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(set.contains(s.charAt(c))){
                set.remove(s.charAt(left++));
            }
            set.add(c);
            maxLen = Math.max(maxLen,right - left+1);
        }
        return maxLen;
    }
}
