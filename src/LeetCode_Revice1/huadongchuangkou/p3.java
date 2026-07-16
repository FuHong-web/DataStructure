package LeetCode_Revice1.huadongchuangkou;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/1 22:11
 * @desc:无重复的最长字符串字串
 */
public class p3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int ringht = 0; ringht < s.length(); ringht++) {
            while (set.contains(s.charAt(ringht))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(ringht));
            maxLen = Math.max(maxLen,ringht-left+1);
        }
        return maxLen;
    }
}
