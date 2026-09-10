package LeetCode_Revice4.duoweidongtaiguihua;
/*最长回文子串*/
public class p5 {
    public String longestPalindrome(String s) {
        int maxRes= 0;
        int startLeft = 0;

        for (int i = 0; i < s.length(); i++) {

            int left = i;
            int rigth = i;
            while (left >= 0 && rigth < s.length() && s.charAt(left) == s.charAt(rigth)){
                if(rigth - left + 1 > maxRes){
                    maxRes = rigth - left +1;
                    startLeft = left;
                }
                left--;
                rigth++;
            }

            left = i;
            rigth = i+1;
            while (left >= 0 && rigth < s.length() && s.charAt(left) == s.charAt(rigth)){
                if(rigth - left + 1 > maxRes){
                    maxRes = rigth -left + 1;
                    startLeft = left;
                }
                left--;
                rigth++;
            }
        }
        return s.substring(startLeft,startLeft+maxRes);
    }
}
