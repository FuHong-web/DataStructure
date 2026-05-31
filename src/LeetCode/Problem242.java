package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/9 20:41
 * @desc:力扣第242题有效的字母异位词
 */
public class Problem242 {
    public static void main(String[] args) {
        String s="anagram";
        String t="naiaram";
        System.out.println(isAnagramq1(s,t));
        System.out.println(isAnagram2(s,t));
    }
    //方法一:排序
    public static boolean isAnagramq1(String s, String t){
        if (s.length()!=t.length()){
            return false;
        }
        char[] c1=new char[s.length()];
        char[] c2=new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch1= (s.charAt(i));
            c1[i]=ch1;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch2= (t.charAt(i));
            c2[i]=ch2;
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i=0;i<c1.length;i++){
            if (c1[i]!=c2[i]){
                return false;
            }
        }
        return true;
    }
    //方法二：Hash表
    public static boolean isAnagram2(String s, String t){
        if (s.length()!=t.length()){
            return false;
        }
        int[] tables=new int[26];
        for (int i=0;i<s.length();i++){
            tables[s.charAt(i)-'a']++;
        }
        for (int i=0;i<t.length();i++){
            tables[t.charAt(i)-'a']--;
            if (tables[t.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }

}
