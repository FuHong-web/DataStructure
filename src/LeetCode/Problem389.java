package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/10 15:30
 * @desc:力扣第389题：
 */
public class Problem389 {
    public static void main(String[] args) {
        String s = "abde";
        String t = "abcde";
        Problem389 p389 = new Problem389();
        System.out.println(p389.findTheDifference1(s, t));
        System.out.println(p389.findTheDifference2(s, t));
    }

    //方法一：计数
    public char findTheDifference1(String s, String t) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            chars[c1 - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c2 = t.charAt(i);
            chars[c2 - 'a']--;
            if (chars[c2 - 'a'] < 0) {
                return c2;
            }
        }
        return ' ';
    }

    //方法二：求和
    public char findTheDifference2(String s, String t) {
        int as = 0;
        int ts = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ts += t.charAt(i);
        }
        return (char) (ts-as);
    }
}