package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/20 16:25
 * @desc:力扣第1332题
 */
public class Problem1332 {
    public static void main(String[] args) {
        String s="aabaa";
        Problem1332 p1332 = new Problem1332();
        System.out.println(p1332.removePalindromeSub(s));
    }
    public int removePalindromeSub(String s) {
        int i=0;
        int j=s.length()-1;
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)){
                return 2;
            }
            i++;
            j--;
        }
        return 1;
    }
}
