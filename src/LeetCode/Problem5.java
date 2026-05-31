package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/12/30 16:15
 * @desc:力扣第5题：最长回文子字符串
 */
public class Problem5 {
    public String longestPalindrome(String s) {
        int reslength=0;
        int res_start=0;
        for(int i=0;i<s.length();i++){
            //bab
            int left=i;
            int right=i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right-left+1>reslength){
                    reslength=right-left+1;
                    res_start=left;
                }
                left--;
                right++;
            }
            //baab
            left=i;
            right=i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right-left+1>reslength){
                    reslength=right-left+1;
                    res_start=left;
                }
                left--;
                right++;
            }
        }
        return s.substring(res_start, res_start + reslength);
    }
}
