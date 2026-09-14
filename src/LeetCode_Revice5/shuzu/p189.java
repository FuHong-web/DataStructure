package LeetCode_Revice5.shuzu;

import java.util.Arrays;

/*轮转数组*/
public class p189 {
    public void rotate(int[] nums,int k){
        int n  = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[(i+k) % n];
        }
        System.arraycopy(temp,0,nums,0,n);
    }
}
