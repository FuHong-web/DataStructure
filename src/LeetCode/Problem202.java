package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/16 23:05
 * @desc:力扣第202题
 */
public class Problem202 {
    public static void main(String[] args) {
        int a=23;
        Problem202 p202 = new Problem202();
        System.out.println(p202.isHappy1(a));
    }
    //方法一：Hash集合
    public boolean isHappy1(int n) {
        Set<Integer> set=new HashSet<>();
        while (n!=1&&!set.contains(n)){
            set.add(n);
            n=getNext(n);
        }
        return n==1;
    }
    //方法二：双指针
    public boolean isHappy2(int n){
        int slow=n;
        int fast=getNext(n);
        while (fast!=1&&fast!=slow){
            slow=getNext(slow);
            fast=getNext(getNext(fast));
        }
        return fast==1;
    }
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
